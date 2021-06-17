# language: pt
	# encoding: utf-8

Funcionalidade: Acessar o site da accenture e aceitar os cookies do LGPD

Cenario: Configurações do cookie
		Dado que eu estou na pagina inicial da accenture
		Quando abrir as configuraçoes de cookies
		E clico em confirmar minhas escolhas
		E clico no botão configurações de cookie
		Então devo ver o item de sua privacidade
		E devo ver Cookies estritamente necessárias
		E devo ver Cookies Analíticos de Primeira Parte
		E devo ver Cookies de Desempenho e Cookies Funcionais
		Então devo ver Cookies de Publicidade e Redes Sociais