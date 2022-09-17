
# RI-API

A funcionalidade principal foi quebrada em algumas partes para ficar melhor de projetar, mas em texto corrido nossa funcionalidade principal é um usuário gravar um áudio avaliando a aula de um professor pela aplicação em react native que se comunicará com nossa API em java que realizará o upload desse arquivo no GOOGLE-DRIVE pela API do mesmo e salvará o id e nome desse arquivo em nosso banco de dados para que quando chamada a API em python não seja necessário passar o arquivo por completo e sim somente um id que a mesma realizará o download do arquivo e passará para um Speech-to-text que transformará esse áudio em um texto, e assim passará para um IA classificar a nota que esse aluno deu para aula do professor, após esses passos retornará o texto e a nota para API em java que salvará essas informações adicionais na base de dados.

# Tabela dos endpoints
 
- [Tablela](https://endpoints-nu.vercel.app)


## Documentação das funcionalidades

| Descrição   | Porcentagem|
| :---------- | :--------- |
|`Gravação do áudio via react native pelo usuário.`|`70%`|
|`API em java para receber o áudio e enviá-lo para a nuvem pela API-GOOGLE-DRIVE.`|`80%`|
|`API em Python que realizará o download da API-GOOGLE-DRIVE.`|`100%`|
|`Speech-To-Text para transformar o áudio em texto.`|`100%`|
|`IA que classifica qual nota o aluno deu para aula do professor.`|`20%`|
|`Retorno dessas informações para API em java e ela realizará a gravação no banco de dados.`|`80%`|

### Funcionalidade extra
E para treino dessa IA e verificar a vitalidade e accuracy dela iremos realizar a criação de um cron para que a cada certo período de tempo ele requisite para API em java as informações de texto e nota e possa fazer o treino


# Descrição da problematica e solução do grupo
É certo afirmar que nas escolas e universidades, muitos alunos podem se sentir desconfortáveis em expressar seu descontentamento ou contentamento diretamente com o professor sobre as aulas dadas, por conta de vergonha, ou até medo do retorno que pode receber. Frustrações, queda de expectativas são normais no ambiente escolar, e quando os alunos não veem mudanças em coisas que os incomodam, pelo simples fato de nunca dizer, acabam desistindo de prosseguir com as aulas. Da mesma forma os professores não alteram seu modo de didática, pois não tem consciência que a forma que leciona não agrada seus alunos.
De acordo com uma matéria do site hrcentral “O feedback é vital para o desenvolvimento contínuo dos funcionários. O feedback esclarece as expectativas, ajuda as pessoas a aprender com seus erros e aumenta a confiança.”
Juntando o problema das escolas, e a afirmação do site, foi pensado a idéia para a criação da aplicação Rate It, um aplicativo de feedbacks para alunos e professores, ao acessá-lo é informado uma listagem feita pela instituição cadastrada das aulas ocorridas, assim o aluno seleciona a aula na qual possui interesse em dar um feedback que pode ser positivo, construtivo, negativo ou corretivo.
Deste modo o aluno e o professor tem proveito, o acadêmico conseguirá expressar suas opiniões, angústias, ou elogios de forma anônima garantindo sua privacidade, e o docente se beneficiará pois profissionais que recebem feedbacks constantemente são mais comprometidos, uma vez que são reconhecidos pelos seus acertos e estão cientes de onde precisam melhorar.

Benefícios que a cultura do feedback pode trazer:
Motivação
Produtividade
Retenção de talentos
Identificação e correção de problemas

Funcionamento

Instituições: Ao baixar o aplicativo irá ser apresentado os planos disponíveis, após a instituição escolher a proposta que melhor se encaixa na sua realidade. Um token é gerado, e é este token que será usado pelos usuários, sejam eles professores ou aluno, para informar que é desta instituição cadastrada que eles pertencem.
Professores: Inicialmente é apresentado uma página de login, após o acesso, o docente abre uma sala virtual informando sua matéria e uma descrição da aula, assim é gerado um código para o mesmo informar aos alunos no final de cada aula, o formulário para preenchimento ficará disponível até a aula seguinte.

Estudantes: Inicialmente é apresentado uma página de login, onde será informado o RM e senha, posteriormente um campo onde será inserido o código da aula, ao abrir a tela de feedbacks, é solicitado a gravação de um áudio informando o que achou da aula, do conteúdo, da didática do professor, aproveitamento, etc. A quantidade de estrelas na avaliação (0 a 5), é feita através de uma IA que analisa as frases do áudio, se foram ditas coisas boas, a avaliação é alta, se foram ditas coisas ruins, a avaliação é baixa.

A página de avaliação conterá as seguintes abas para realizar o feedback (cada um receberá um respectivo áudio detalhando o que achou):
- Conteúdo da aula
- Didática da aula
- Aproveitamento
- Absorção da matéria
- Outro

A avaliação irá servir também como uma base para o professor de quem participou da aula (como uma chamada), será computado quem realizou o feedback, mas não diretamente de quem pertence cada um, a avaliação será de forma anônima para o aluno ter maior liberdade para expressar o que desejar.
*As avaliações serão diretamente de alunos para professores
*A validação das instituições seria feita através de CNPJ
*Todo aplicativo terá acessibilidade para deficientes visuais
*Essa primeira versão do aplicativo procura focar em instituições escolares, mas futuramente busca se implementar em outros segmentos

## Fluxograma e Proposta de Solução

 - [Miro](https://miro.com/app/board/uXjVPbhgzVs=/)

## Fluxograma

<a href="https://ibb.co/kG8GLp0"><img src="https://i.ibb.co/Cw7wjqv/Whats-App-Image-2022-09-11-at-16-37-00.jpg" alt="Whats-App-Image-2022-09-11-at-16-37-00" border="0"/></a>

## Proposta de Solução

<a href="https://ibb.co/wwpVtCM"><img src="https://i.ibb.co/qWmK69k/Whats-App-Image-2022-09-11-at-16-36-41.jpg" alt="Whats-App-Image-2022-09-11-at-16-36-41" border="0"/>
</a>

