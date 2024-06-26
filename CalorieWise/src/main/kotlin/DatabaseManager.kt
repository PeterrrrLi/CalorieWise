import java.sql.Connection
import java.sql.DriverManager

class DatabaseManager(
    hostname: String = "xx.xx.xx.xx",
    schemaName: String = "calorie-wise",
    username: String = "root",
    password: String = "xxxxxxxxxxxxxxxxxx"
) {
    private val jdbcUrl: String = "jdbc:mysql://$hostname/$schemaName?user=$username&password=$password"
    private val connection: Connection = establishConnection()

    // Establish a database connection
    private fun establishConnection(): Connection {
        println("Establishing connection!")
        Class.forName("com.mysql.cj.jdbc.Driver")
        return DriverManager.getConnection(jdbcUrl)
    }

    // Get the connection to the database
    fun getConnection(): Connection {
        if (connection.isClosed) {
            establishConnection()
        }
        println("Connection Successful!")
        return connection
    }
}
