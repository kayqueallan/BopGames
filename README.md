# BOP GAMES - Cycling Tour Management System

## Authors
This project was developed by **Kayque Allan** and **Davi Vinicius** as part of a Modular Programming assignment at PUC Minas University in Belo Horizonte, Coração Eucarístico.

## Project Description
The BOP GAMES project is an implementation of a system to manage the cycling event of a multi-sport competition in Latin America. The main focus is to register and track the performances of cyclists across 21 sequential stages, determining the winner based on the lowest total time spent.

## Main Features
- **Cyclist Registration**: Each cyclist has a name, identification number, and city of origin. The system stores data about the 21 stages that each cyclist participates in.

- **Stage Management**: Each stage is registered with a number, date, start time, and duration. This allows for detailed tracking of each cyclist's performance.

- **Comparison between Cyclists**: The system allows for comparison between two cyclists, identifying who finished ahead in the competition and calculating the time difference in minutes and seconds.

- **Results of Specific Stages**: It is possible to check who won a specific stage between two cyclists, providing a more granular analysis of performance.

## Project Structure
The project utilizes an object-oriented approach, implementing the following main classes:

- **Cyclist**: Represents the cyclists and contains methods for calculating total time, adding stages, and comparing cyclists.

- **Stage**: Represents each of the 21 stages, storing information about the date, time, and durations for cyclists.

- **Duration**: A helper class that represents duration in a structured way, allowing operations such as addition and time difference.

- **Hour**: A class that facilitates the manipulation of time, storing hours, minutes, and seconds.

- **Date**: A class that represents dates with day, month, and year.

## Unit Tests
Unit tests have been implemented to ensure the correct functionality of the methods, including:

- Calculating the time difference between cyclists.
- Verifying who won in specific stages.

## Test Examples
- **CyclistTest**: Tests the creation of cyclists and the addition of stages.

## UML Diagram
A UML diagram has been created to represent the structure and relationships of the classes in the system.

## Video
A demonstration video has been produced, showcasing the UML diagram, the source code, and the tests conducted.
