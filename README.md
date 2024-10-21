# BOP GAMES - Sistema de Gestão da Volta de Ciclismo

## Autores

Este projeto foi desenvolvido por **Kayque Allan** e **Davi Vinicius** como parte de um trabalho de Programação Modular na faculdade PUC Minas de Belo Horizonte, Coração Eucarístico.

## Descrição do Projeto

O projeto BOP GAMES é uma implementação de um sistema para gerenciar a modalidade de ciclismo de um evento multiesportivo da América Latina. O foco principal é registrar e acompanhar as performances dos ciclistas em 21 etapas sequenciais, determinando o vencedor com base no menor tempo total gasto.

## Funcionalidades Principais

- **Registro de Ciclistas**: Cada ciclista possui um nome, número de identificação e cidade de origem. O sistema armazena dados sobre as 21 etapas que cada ciclista participa.

- **Gestão das Etapas**: Cada etapa é registrada com um número, data, hora inicial e duração. Isso permite um acompanhamento detalhado do desempenho de cada ciclista.

- **Comparação entre Ciclistas**: O sistema permite comparar dois ciclistas, identificando quem terminou à frente na competição e calculando a diferença de tempo em minutos e segundos.

- **Resultados de Etapas Específicas**: É possível verificar quem venceu uma etapa específica entre dois ciclistas, proporcionando uma análise mais granular do desempenho.

## Estrutura do Projeto

O projeto utiliza uma abordagem orientada a objetos, implementando as seguintes classes principais:

- **Ciclista**: Representa os ciclistas e contém métodos para calcular o tempo total, adicionar etapas e comparar ciclistas.

- **Etapa**: Representa cada uma das 21 etapas, armazenando informações sobre data, hora e durações para ciclistas.

- **Duracao**: Classe auxiliar que representa a duração de forma estruturada, permitindo operações como soma e diferença de tempos.

- **Hora**: Classe que facilita a manipulação de horários, armazenando horas, minutos e segundos.

- **Data**: Classe que representa datas com dia, mês e ano.

## Testes Unitários

Testes unitários foram implementados para garantir a correta funcionalidade dos métodos, incluindo:

- Cálculo da diferença de tempo entre ciclistas.
- Verificação de quem venceu em etapas específicas.

### Exemplos de Testes

- **CiclistaTest**: Testa a criação de ciclistas e a adição de etapas.
