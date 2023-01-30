import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexion {
    public conexion(){
        try {
            // Se regustra el Driver de MySql
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Estudiantes", "root", "UGPCUGR2002"
            );

            Statement s = conexion.createStatement();

            ResultSet rs = s.executeQuery("select * from Amigos");

            while (rs.next()){
                String mensaje =
                        String.format(rs.getString("Nombre") + " " + rs.getString(2));
                //JOptionPane.showMessageDialog(null, mensaje);
                new VentanaMySql().Datos.setText(mensaje);
                //System.out.println(rs.getString("Nombre") + " " + rs.getString(2));
            }

            conexion.close();
        }
        catch (Exception e){
            e.printStackTrace();
        };
    }
}
