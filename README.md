# Reader Diary

Aplicativo de acompanhamento a leitura e organização das mesmas.

## Getting Started:

O Reader Diary é um aplicativo multiusuário possuindo um sistema de cadastro e login,onde seus dados e posteriormente seus livros serão salvos localmente na própria aplicação.

O aplicativo permite o usuário adicionar seus livros,separando em status: Interessado,Lendo e por fim Lido,tendo assim um acompanhamento do estado das leituras.Para cada livro adicionado em estado de lendo é possível checar o seu progresso à medida que for atualizado a página atual da leitura.E para cada livro lido é possível avaliar e fazer comentários sobre o mesmo.

Para cada livro adicionado é possível inserir capítulos e comentários nos mesmos,fazendo breves resumos e anotações.Podendo também avaliar o livro caso tenha gostado ou não.
	

### Instalação & Requisitos Mínimos->

A apk do aplicativo está disponivel neste repositorio bastando apenas fazer o download e instalar no seu dispositivo android.

API 21: Android 5.0(Lollipop);
Versão mínima do SDK: 22;

## Relacionamento das classes e diagrama

* Usuário

	id;
	
	nome;
	
	senha;
	
	email;
	
* Livro

	id;
	
	titulo;
	
	autor;
	
	status;
	
	genero;]
	
	ano;
	
	pagina atual;
	
	quantidade total de paginas;
	
	data de inicio de leitura;
	
	data de termino de leitura;
	
	nota de avaliação;
	
* Capítulos

	id;
	
	numero do capitulo;
	
	titulo;
	
* Comentário

	descrição;
	
	data e hora;


	
