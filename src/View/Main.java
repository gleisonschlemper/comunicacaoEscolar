package View;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import Controller.Escola;
import Model.Aluno;
import Model.Endereco;
import Model.Mae;
import Model.Matricula;
import Model.Mensagem;
import Model.Pai;
import Model.Pais;
import Model.Professor;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
       Escola escola = new Escola();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date dataNascimento = sdf.parse("1998-01-15");
       java.util.Date dataMatricula = sdf.parse("2023-11-03");
        
        // LISTAGEM DE ALUNOS
       
       List <Aluno> alunos = escola.listarAlunos();
        for (Aluno aluno : alunos) {
           System.out.println(aluno.getPais().getCodigo());
           System.out.println(aluno.getEndereco().getCodigo());
       } 
        

       // CADASTRO DO ALUNO
      
        /*
       
          Aluno aluno = new Aluno(
               "1161213543",
               "Marcos",
               "Schlemper",
               "gleisonschlemper532@gmail.com",
               "12345", 
               30,
               new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-15").getTime()), 
               new Matricula(
            		 4,
             		 new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-15").getTime())  
             	)
          );
          

       Pai pai = new Pai(
          		"12345678901",
          	    "Maria",
          	    "Silva",
          	    30, // Idade da mãe
          	    new java.sql.Date(dataNascimento.getTime())
              );

        Mae mae = new Mae(
          		"12345678901",
          	    "Maria",
          	    "Silva",
          	    30, // Idade da mãe
          	    new java.sql.Date(dataNascimento.getTime())
              );
          
       Pais pais = new Pais(
    		   "familiaSchlemper@gmail.com",
    		   "12345",
    		   mae,
    		   pai
    	);
       
       Endereco endereco = new Endereco(
    		   "kkkkk",
    		   "kkkkk",
    		   123,
    		   "12345-678"  		   
    		);

       // ADD ALUNO CONTENDO OS OBJETOS ENDERECO, MATRICULA E PAIS
       	//aluno.addPais(pais);
       	//aluno.addEndereco(endereco);
       //	System.out.println(escola.cadastrarAluno(aluno));
        
        */
        
        
        // PARTE 3 
        
        //escola.deletarAluno(aluno);
        // System.out.println(escola.alterarEnderecoAluno(aluno)); ;
        
       	Aluno aluno = new Aluno(new Matricula(5), "1161213543");
       	aluno.addEndereco(new Endereco("Main Street","Cityville",123,"12345-678"));
        System.out.println(escola.alterarEnderecoAluno(aluno));
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       /*  Aluno novoAluno = new Aluno(
             "11682549985",
             "Gleison",
             "Schlemper",
             "gleisonschlemper532@gmail.com",
             "12345", 
             30,
             new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-15").getTime()), 
             new Matricula(
           		 new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-15").getTime())  
           	),
     
        );
        
        System.out.println(escola.cadastrarAluno(novoAluno)); 
        */
        
        /* 
       Aluno novoAluno = new Aluno(
               "11682549985",
               "Marcos",
               "Schlemper",
               "gleisonschlemper532@gmail.com",
               "12345", 
               30,
               new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-15").getTime()), 
               new Matricula(
             		 new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-15").getTime())  
             	)
          );
       
       System.out.println(escola.alterarAluno(novoAluno)); 
         */
       
       
      // Aluno Gleison = escola.verAluno(new Aluno(new Matricula(16), "11682549985"));
      // System.out.println(Gleison.getSenha());
       
   
     
       /* 
        * 
        *   
          
       
      // aluno.addPais(pais);
       //aluno.addEndereco(endereco);
       //System.out.println(escola.cadastrarPais(aluno.getPais()));
       //System.out.println(escola.cadastrarEndereco(aluno.getEndereco()));
       //System.out.println(escola.cadastrarAluno(aluno));
       //System.out.println(escola.relacionarPaisEaluno(aluno));
       //System.out.println(escola.relacionarEnderecoEaluno(aluno));
       
       
      // System.out.println(escola.cadastrarPaisEaluno(aluno));
       
       /*
       Endereco endereco = new Endereco(
    		   "Main Street",
    		   "Cityville",
    		   123,
    		   "12345-678"  		   
    		);
       
       aluno.addEndereco(endereco);
       */
  
       //System.out.println(escola.cadastrarPais(pais));
       //System.out.println(escola.verPais(pais));
      // System.out.println(escola.verificarPais(pais));
       
       
       
       
/*
       
       Pai pai = new Pai("12345678901");
       Mae mae = new Mae("12345678901");
       Pais pais = new Pais(mae,pai);
       System.out.println(escola.verPais(pais));
       
       */
       /* 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataNascimento = sdf.parse("1998-01-15");
        java.util.Date dataMatricula = sdf.parse("2023-11-03");
        // Create a new Aluno object with the data to be inserted
        Aluno novoAluno = new Aluno(
            "000",
            "Gleison",
            "Silva",
            "marquinho@example.com",
            "12345",
            25,
            new java.sql.Date(dataNascimento.getTime()),
            new java.sql.Date(dataMatricula.getTime())
        );

        String resultadoInsercao = escola.cadastarAluno(novoAluno);
        System.out.println(resultadoInsercao); 
        */
        
		// Aluno aluno = new Aluno("000");
		// escola.verificarAlunoExiste(aluno);
		
        	

        
    	/*System.out.println( 
    			escola.alterarAluno(
	                "000",
	                "NovoNome",
	                "kkkkkkSobrenome",
	                "novoemail@example.com",
	                30,
	                new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-01-15").getTime())  
    			)
    		);
        /*
         
        
        // PARTE  2
        
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date  dataNascimento = sdf.parse("2023-11-03");

        // Supondo que existam classes Professor, Aluno e Mensagem
        Professor professor = new Professor("xxxxxx", "Antonio", "xxxxx", 25, new java.sql.Date( dataNascimento.getTime()));

        Aluno gleison = new Aluno(
            "12345678901",
            "João",
            "Silva",
            "joao@example.com",
            "12345",
            25,
            new java.sql.Date( dataNascimento.getTime()),
            new java.sql.Date( dataNascimento.getTime())
        );

        gleison.pegarProf(professor);
        Mensagem mensagem = new Mensagem("Professor", "Assunto da mensagem", "Conteúdo da mensagem", new Date(0),  new java.sql.Date( dataNascimento.getTime()));
        
        professor.enviarMensagem(gleison, mensagem);
        Mensagem mensagem2 = new Mensagem("Professor", "Assunto da mensagem", "Conteúdo da mensagem", new Date(0),  new java.sql.Date( dataNascimento.getTime()));
        
        professor.enviarMensagem(gleison, mensagem2);
        // Receba as mensagens do aluno
        List<Mensagem> mensagensRecebidas = gleison.getMensagens();
        for (Mensagem men : mensagensRecebidas) {
            System.out.println("Assunto: " + men.getAssunto());
            System.out.println("Conteúdo: " + men.getConteudo());
            System.out.println("Data de Envio: " + men.getDataEnvio());
            System.out.println("----");
        }
        */
        
        
        // 3 - 
        
        /*
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date  dataNascimento = sdf.parse("2023-11-03");

        // Supondo que existam classes Professor, Aluno e Mensagem
       // Professor professor = new Professor("xxxxxx", "Antonio", "xxxxx", 25, new java.sql.Date( dataNascimento.getTime()));

        Aluno gleison = new Aluno(
            "12345678901",
            "João",
            "Silva",
            "joao@example.com",
            "12345",
            25,
            new java.sql.Date( dataNascimento.getTime()),
            new java.sql.Date( dataNascimento.getTime())
        );
        
        // String cpf, String nome, String sobrenome, int idade, Date dataNascimento
        Pai pai = new Pai(
        		"12345678901",
        	    "Maria",
        	    "Silva",
        	    30, // Idade da mãe
        	    new java.sql.Date(dataNascimento.getTime())
            );

        Mae mae = new Mae(
        		"12345678901",
        	    "Maria",
        	    "Silva",
        	    30, // Idade da mãe
        	    new java.sql.Date(dataNascimento.getTime())
            );
            
        Pais pais = new Pais();
        pais.setMae(mae);
        pais.setPai(pai);
        gleison.addPais(pais);
        // System.out.println(gleison.verMae());
 

	
        
        //System.out.println(escola.alunoExiste(1, "12345"));
       // System.out.println(escola.verPaisDoAluno(1));
        	*/
        

        
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       // java.util.Date  dataNascimento = sdf.parse("2023-11-03");
        //PARTE 4 - ALTERAÇÃO DO ALUNO        
        /*System.out.println(
        		escola.alterarAluno(
                        5,
                        "NovoNome",
                        "kkkkkkSobrenome",
                        "novoemail@example.com",
                        30,
                        new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1993-01-15").getTime())  
        	)
        );*/
         
        
    }
}
