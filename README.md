
# RI-API

A funcionalidade principal foi quebrada em algumas partes para ficar melhor de projetar, mas em texto corrido nossa funcionalidade principal é um usuário gravar um áudio avaliando a aula de um professor pela aplicação em react native que se comunicará com nossa API em java que realizará o upload desse arquivo no GOOGLE-DRIVE pela API do mesmo e salvará o id e nome desse arquivo em nosso banco de dados para que quando chamada a API em python não seja necessário passar o arquivo por completo e sim somente um id que a mesma realizará o download do arquivo e passará para um Speech-to-text que transformará esse áudio em um texto, e assim passará para um IA classificar a nota que esse aluno deu para aula do professor, após esses passos retornará o texto e a nota para API em java que salvará essas informações adicionais na base de dados.

# Tabela dos endpoints
 
- [Tablela](https://endpoints-nu.vercel.app)


## Documentação das funcionalidades

| Descrição   | Porcentagem|
| :---------- | :--------- |
|`Gravação do áudio via react native pelo usuário.`|`70%`|
|`API em java para receber o áudio e enviá-lo para a nuvem pela API-GOOGLE-DRIVE.`|`80%`|
|`Speech-To-Text para transformar o áudio em texto.`|`100%`|
|`IA que classifica qual nota o aluno deu para aula do professor.`|`20%`|
|`Retorno dessas informações para API em java e ela realizará a gravação no banco de dados.`|`80%`|

### Funcionalidade extra
E para treino dessa IA e verificar a vitalidade e accuracy dela iremos realizar a criação de um cron para que a cada certo período de tempo ele requisite para API em java as informações de texto e nota e possa fazer o treino




## Roadmap

- Melhorar o suporte de navegadores

- Adicionar mais integrações

