# AGENTS.md

This is a Spring Boot project of an API that runs within a Docker and uses a PostgresSQL database to store our informations.
The Information of dependencies as well as other parameters are present in the application.yaml file found in the `src/main/ressources` repository.
the aim of this project is to make an API able to feed information about entities to another application trough HTML Requests.
We currently have two entities, Rocks and Miners, a Miner can have many Rocks, a Rock can only belong to one Miner.
The service interface that we use to organise our CRUD functionality is SplService, it is then implemented in SplServiceImpl.
Our controller, SplController, gives entry access to our API.

## Ask before generating

If the task doesn't specify, ask rather than guess:
