# restclientspring
[![Build status](https://travis-ci.org/giuliana-bezerra/restclientspring.svg?branch=master)](https://travis-ci.org/giuliana-bezerra/restclientspring) [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=br.com%3Arestclientspring&metric=alert_status)](https://sonarcloud.io/dashboard/index/br.com:restclientspring)


#### Table of Contents

1. [Overview](#overview)
2. [Setup](#setup)
3. [Usage](#usage)
4. [Reference](#reference)
5. [Limitations](#limitations)
6. [Development](#development)

## Overview
This app configures a generic REST client using Spring which is responsible for performing calls to a target server.

## Setup
This app depends on:

- Java 8
- Maven 3.3.9

Follow the steps to execute the app:

1. Download the repository:
```
git clone git@github.com:giuliana-bezerra/restclientspring.git
```
2. Generate the jar using Maven:
```
mvn clean
mvn package
```
3. Import the generated jar to a project.

## Usage
The client can be used either to GET or POST calls. RestClient can be injected and used for calling services throughout GET and POST HTTP methods. To this end, a request (Request class) and a resource should be passed to this client. The Resource is a class that implements the resource interface, which represents the resource accessed by the service client.

## Reference
See javadoc.

## Limitations
This app only supports GET and POST operations.

## Development
This app implements a base client that allows remote calls to a REST service. Contributions could be adding support to other operations and
authentication strategies.
