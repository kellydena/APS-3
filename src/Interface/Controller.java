package Interface;

import java.util.List;
import java.util.Scanner;

import entidade.Aluno;
import entidade.CadastroAluno;
import entidade.CadastroNotas;
import entidade.Curso;
import entidade.Nota;
import leituraCSV.LeitorAluno;
import leituraCSV.LeitorCursos;
import leituraCSV.LeitorNotas;
import leituraCSV.NovoAluno;
import leituraCSV.NovoCurso;

public class Controller {
	
	View view;
	
	public Controller(View aView) {
		this.view = aView;
	}
	
	public void init() {
		
		Acao resposta = null;
		
		while(resposta != Acao.SAIR) {
			resposta = view.getAcao();
			System.out.println("Sua escolha foi " + resposta);
			
			if(resposta==Acao.cursos) {
				List<Curso> cursos = LeitorCursos.getCursos();
				
				for(Curso curso: cursos ) {
					System.out.println(curso);
				}	
			}
			if(resposta==Acao.alunos) {
				List<Aluno> alunos = LeitorAluno.getAlunos();

				CadastroAluno cadastro = new CadastroAluno();
				cadastro.addAluno(alunos);

				System.out.println(cadastro);
			}
			if(resposta == Acao.historicoAluno) {
				
			}
			if(resposta == Acao.rendimento) {
				List<Nota> notas = LeitorNotas.getNotas();

				CadastroNotas cadastrosNotas = new CadastroNotas();
				cadastrosNotas.addAluno(notas);

				System.out.println(cadastrosNotas);
				
			}
			if(resposta == Acao.novoAluno) {
				NovoAluno novoAluno = new NovoAluno();
				novoAluno.AddAluno();
				
			}
			if(resposta == Acao.novoCurso) {
				NovoCurso.novoCurso();
				
			}
			if(resposta == Acao.novoRendimento) {
				
			}
			if(resposta == Acao.SAIR) {
				view.sendGoodByMessage();
			}
		}
	
		
	}

}
