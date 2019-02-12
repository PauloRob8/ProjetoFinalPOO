# Reader Diary

Aplicativo de acompanhamento a leitura e organização das mesmas.

## Getting Started:

O Reader Diary é um aplicativo multiusuário possuindo um sistema de cadastro e login,onde seus dados e posteriormente seus livros serão salvos localmente na própria aplicação.

O aplicativo permite o usuário adicionar seus livros,separando em status: Interessado,Lendo e por fim Lido,tendo assim um acompanhamento do estado das leituras.Para cada livro adicionado em estado de lendo é possível checar o seu progresso à medida que for atualizado a página atual da leitura.E para cada livro lido é possível avaliar e fazer comentários sobre o mesmo.

Para cada livro adicionado é possível inserir capítulos e comentários fazendo breves resumos e anotações.Podendo também avaliar o livro e marcar os capítulos indicando algo importante neles assim como favorita-los.
	

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
- Capítulos podem ser marcados e favoritados.

**Diagrama**
	

![diagrama de classe readerdiary 2](https://user-images.githubusercontent.com/33494009/52458260-8ffd7100-2b45-11e9-974a-a9a2cf6d9e74.jpeg)



## StoryBoard



## Relacionamento das telas
