

create database app;

use app;

create table cliente(
	codigo int not null primary key auto_increment,
	nome varchar(80)
);
select * from cliente;

create table funcionario(
                        codigo int not null primary key auto_increment,
                        nome varchar(80),
                        cargo varchar(80)
);

insert into funcionario (codigo,  nome, cargo) values (null, 'João', 'Diretor');
insert into funcionario (codigo,  nome, cargo) values (null, 'Maria', 'Gerente');
insert into funcionario (codigo,  nome, cargo) values (null, 'Marielle', 'CEO');

select * from funcionario;

create table produto(
	codigo int not null primary key auto_increment,
	descricao varchar(120),
	preco double
);

insert into produto (codigo,  descricao, preco) values (null, 'Macarrão a bolonheza', 100);
insert into produto (codigo,  descricao, preco) values (null, 'Bife com fritas', 200);
insert into produto (codigo,  descricao, preco) values (null, 'Coca-cola', 8);

create table pedido (
	codigo int not null primary key auto_increment,
	data date,
	cliente_cod int,
	foreign key (cliente_cod) references cliente(codigo)
);


create table itens_pedido (
	codigo int not null primary key auto_increment,
	pedido_cod int,
	produto_cod int,
	foreign key (pedido_cod) references pedido(codigo),
	foreign key (produto_cod) references produto(codigo)
);

insert into pedido (codigo, data, cliente_cod) values (null, '2022-10-22', 4);


insert into itens_pedido (codigo, pedido_cod, produto_cod) value (null, 1, 1);
insert into itens_pedido (codigo, pedido_cod, produto_cod) value (null, 1, 2);
insert into itens_pedido (codigo, pedido_cod, produto_cod) value (null, 1, 3);


select p.codigo, p.data, c.nome, pr.descricao, pr.preco from pedido p 
	join cliente c
	join itens_pedido i
	join produto pr
	on p.cliente_cod = c.codigo
	and p.codigo = i.pedido_cod
	and pr.codigo = i.produto_cod;