# language: pt
	# encoding: utf-8

Funcionalidade: Acessar o site da accenture e aceitar os cookies do LGPD

Cenário: Aceitar o cookie LGPD
		Dado que eu estou no site da accenture
		Quando abro as configuraçoes de cookies
		E clico em Confirmar minhas escolhas
		Então deve fechar o modal
