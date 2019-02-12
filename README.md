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

- Tela de Login onde o usuário entrara na aplicação e tela de cadastro para caso o usuário não possua uma conta

![login](https://user-images.githubusercontent.com/33494009/52617797-1d153280-2e84-11e9-9c7b-52b945f90efd.png)
![cadastro](https://user-images.githubusercontent.com/33494009/52617796-1d153280-2e84-11e9-80ff-7eb74c98557e.png)


- Tela de navegação onde será possível filtrar os livros entre os que estão em estado de lido, lendo e os que se deseja ler, e também realizar o logout e por música de fundo.

![drawer](https://user-images.githubusercontent.com/33494009/52618563-58b0fc00-2e86-11e9-86ad-1183be805602.png)


- Tela que mostra seus livros atuais juntamente com seu progresso,ícone dinâmico que muda dependendo de um gênero específico tais como Ação, Drama, Terror,Romance e etc.No primeiro botão pode-se editar o livro mudar todas as suas informações e atualizar seu progresso, e no segundo terá a opção de remover o livro,e no botão mais abaixo adiciona livros:


- Tela de cadastro de livro onde será inserido os dados do livro e o status dinâmico, onde só serão inseridos data de início de leitura caso o livro esteja em estado de lendo, assim como a página atual. As informações que dependem do status do livro só aparecerão quando o mesmo for selecionado:

![cadastrolivro](https://user-images.githubusercontent.com/33494009/52618901-471c2400-2e87-11e9-912f-cfc329956657.png)


- Tela das informações do livro e seus respectivos capítulos e comentários


![capitulos1](https://user-images.githubusercontent.com/33494009/52618566-59499280-2e86-11e9-8b6e-58f47ab6219a.png)
![capitulo](https://user-images.githubusercontent.com/33494009/52618902-471c2400-2e87-11e9-9149-b09a34dd9120.png)



- Tela de cadastro de capítulos

![cadastrocapitulo](https://user-images.githubusercontent.com/33494009/52618564-58b0fc00-2e86-11e9-929b-4fbcba50da70.png)

## Relacionamento das telas
