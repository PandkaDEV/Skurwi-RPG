package qu.code.main.utilities;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.SneakyThrows;
import qu.code.api.objects.ApiConfig;
import qu.code.main.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class SqlUtil {

    @Getter
    protected static Connection connection;

    @SneakyThrows
    public static void connect(){
        if (isConnected()) return;

        ApiConfig config = Main.getPlugin().getConfig();

        connection = DriverManager.getConnection("jdbc:mysql://"
                        + config.getOrCreate("mysql.host", "localhost")
                        + ":" + config.getOrCreate("mysql.port", 3306) + "/"
                        + config.getOrCreate("mysql.table", "test"),
                config.getOrCreate("mysql.username", "root"),
                config.getOrCreate("mysql.password", ""));

    }
    @SneakyThrows
    public static void disconnect(){
        if (isConnected()) connection.close();
    }

    @SneakyThrows
    public static boolean isConnected(){
        return connection != null && !connection.isClosed();
    }

    @SneakyThrows
    public static PreparedStatement prepareStatement(String text){
        return connection.prepareStatement(text);
    }

    @SneakyThrows
    public static PreparedStatement prepareStatement(String table, Map<String, Object> values) {

        String s = "insert into {table} {values} values {?} on duplicate key update {update}";
        String a = "", b = "", c = "";


        int id = 0;
        for (String s1 : values.keySet()) {
            ++id;
            a += ",'" + s1 + "'";
            b += ",?";
            c += ", " + s1 + "values=(" + s1 + ")";
        }

        a = a.replaceFirst(",", "");
        b = b.replaceFirst(",", "");
        c = c.replaceFirst(", ", "");

        s = s.replace("{table}", table).replace("{values}", a)
                .replace("{?}", b)
                .replace("{update}", c);

        PreparedStatement statement = connection.prepareStatement(s);
        List<Object> objects = Lists.newArrayList(values.values());

        for (int i = 1; i < id+1; i++) {
            statement.setObject(i, objects.get(i-1));
        }

        return connection.prepareStatement(s);
    }
}
