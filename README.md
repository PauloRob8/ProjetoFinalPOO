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
	genero;
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
	
A persitência dos dados será realizada através do banco de dados orientado a objetos e NoSql [ObjectBox](https://objectbox.io/), na aplicação serão criadas Caixas (instâncias do ObjectBox) para armazenar os dados ex:

	```
	public Box<Usuario> usuarioBox;
	usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
	```

Acima foi criado uma instância da box específica para usuários, ou seja, uma caixa de usuários que será usada para armazenar os dados dos mesmos assim criando o esquema multiusário.

**Relacionamentos**
- O usuário faz login/cadastro na aplicação, dentro da aplicação pode-se ter um ou mais usuários.
- O usuário adiciona livros, o mesmo pode ter um ou mais livros.
- Um livro está vinculado a um único usuário, o usuário pode alterar o estado do livro de interessado a lendo e lido.
- O livro pode ser avaliado,removido e editado pelo usuário assim como também podem ser adicionado comentários aos mesmos.
- Um livro pode adicionar um ou mais capítulos, e um capítulo pertence a um único livro.

**Diagrama**
	
![diagrama de classe readerdiary 1](https://user-images.githubusercontent.com/33494009/52454071-502c8e80-2b31-11e9-9253-678509dc9f99.jpeg)


## StoryBoard

![screenshot_2019-01-19-01-24-20](https://user-images.githubusercontent.com/33494009/52457566-9f7abb00-2b41-11e9-9d0d-5bab36eac344.png)
![screenshot_2019-01-19-01-24-27](https://user-images.githubusercontent.com/33494009/52457567-9f7abb00-2b41-11e9-9528-e00445e60d08.png)
![screenshot_2019-01-19-01-24-45](https://user-images.githubusercontent.com/33494009/52457568-9f7abb00-2b41-11e9-8ec5-9eb2a3c66342.png)
