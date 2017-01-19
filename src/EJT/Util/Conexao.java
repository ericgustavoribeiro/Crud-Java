package EJT.Util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexao {
	
	public static Connection conectar;
    public static String status = "Não conectou...";
    
    public static Connection getConnection(int sistema) throws Exception {
		String conexao = "";
		String usuario = "";
		String senha = "";
    	
		if(sistema == Database.MYSQL){
			conexao = "jdbc:mysql:3306//localhost/ejt";
			usuario = "ejt";
			senha = "12345";
		}else {
			throw new IllegalArgumentException("Tipo de banco não suportado");
		}
		if(conectar == null){
			try{
				conectar = DriverManager.getConnection(conexao, usuario, senha);
			}catch (SQLException erro){
				throw new Exception("SQLException => ConnectionManager: " + erro.getMessage());
			}
		}
		
    	return conectar;
	}
    
    public static void close() throws Exception{
    conectar.close();	
    }
////Método Construtor da Classe//
//
//	
////Método de Conexão//
//
//public static java.sql.Connection getConexao() {
//
//	conectar = null;          //atributo do tipo Connection
//
//try {
//
////Carregando o JDBC Driver padrão
//
//String driverName = "com.mysql.jdbc.Driver";                        
//
//Class.forName(driverName);
//
////Configurando a nossa conexão com um banco de dados//
//
//          String serverName = "localhost:3306";
//          String meubanco = "automacao";
//          String url = "jdbc:mysql://" + serverName + "/" + meubanco;
//        ///  String username = "NewUser";
//        ///  String password = "mysql";
//            String username = "root";
//            String password = "123@qwe";
//
//            conectar = DriverManager.getConnection(url, username, password);
//
//          //Testa sua conexão//  
//
//          if (conectar != null) {
//
//              status = ("STATUS--->Conectado com sucesso!");
//                                      
//              
//
//          } else {
//
//              status = ("STATUS--->Não foi possivel realizar conexão");
//
//          }
//
//          return conectar;
//
//      } catch (ClassNotFoundException e) {  //Driver não encontrado
//
//          System.out.println("O driver expecificado nao foi encontrado.");
//
//          return null;
//
//      } catch (SQLException e) {
//
////Não conseguindo se conectar ao banco
//
//          System.out.println("Nao foi possivel conectar ao Banco de Dados.");
//
//          return null;
//
//      }
//
//}
//


	

}
