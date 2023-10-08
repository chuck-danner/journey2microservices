# Intro #
I'm Chuck Danner. I'm a Cloud and System architect at IBM and founder of the Cloud Development Center of Excellence for the Rocket Center Client Innovation Center. I've been working on cloud-based development projects since 2015, and focused on cloud-native application, microservices, and containerization. I'm currently the Lead Systems Architect for the Electronic Records Archive at the National Archives and Records Administration. 

# Microservices #
Microservice Architecture have really gained in popularity over the last decade and are often used in cloud-native application development. 

Today I'm going to:

- Define microservices and microservices architecture
- Discuss when you should consider using them
- Talk about some best practices and potential pitfalls.
- Demonstrate the journey to microservice, going from a monolithic architecture to microservice architecture.

## Define Microservice Architecture #
Microservices architecture is defined as a collection of independent, loosely-coupled, highly-cohesive services that communication with each other over a well-defined protocol. 

So what does that mean. Let's break it down.

## Collection of Services #

Microservices are a variant of Service-Oriented Architecture.  This focused on having a set of discreet service, instead of monolithic design, where everything is in one deployable application. Instead microservices have tens or hundreds of services that deployed and distributed across multiple systems and accessed remotely. 


## Independent # 

Microservices should be able to be developed, tested, deployed, and scaled independently. This is the key factor that give microservices their power. If you have two microservices that require other services to be built with them, then you aren't doing microservices right. You need to combine those services as one or refactor to decouple them.

## Loosely Coupled/Highly Cohesive #

Microservices are typically broken down around a business capability or domain. A single service should hold all of the information and functionality for the capability and should avoid having strict dependencies on other services. 

## Communication #

Microservices communicate with each other over well defined, light-weight protocols. There are two ways that microservices communication with each other. Synchronously and Asynchronously. Synchronous communication follows a response and request patten, usually using RESTful API calls, gRPC, or similar. In this patten the service sends a request and waits for a response to continue processing. Asynchronous communication is usually completed with events, and event-driven architecture. This uses tools like queues and event streams where work is read in from a queue, and then once completed writes the result to a queue to be picked up by the next microservices. You can see this as an assemble line for processing work, and can really be a powerhouse for background processing. 

## Micro vs. Monolith #

The typical comparison is microservice verses a monolithic service. A monolithic service is deployed scaled and managed together. Applications often first start as monolithic applications. Everything is in one place, easy to understand, easy to deploy and easy to manage. If there is an error in the application there is often only one place to look. Where microservices are often distributed across multiple servers. Managing multiple servers is more complex, trying to track down where an issue resides is more complex and managing deployments is more complex, so why do we ever choose microservices over a monolithic service. Scalability, Flexibility, and Failure Isolation.  We have also discovered ways to mitigate many of the issue with microservices, making it the preferred choice in many instances. 


## When should I consider splitting up a monolithic application to microservices? #

Here are three key things that are happening to consider splitting up an application: 

1. Need to be able to scale different parts of an application at a specific time
1. Multiple teams working on an application and getting in each others way
1. Fault isolation and high availability 
1. Technology diversity

# Three Things #

There are three cultural and technological innovations that have really enable microservice to excel. 

1. Agile Development
1. DevOps
1. Containerization

### Agile Development #

Agile development strives to have teams that can operation independently. That can be difficult with large system that have multiple teams supporting them. Teams become dependent on each other, often waiting for other teams to complete code before a deployment can happen, leading to merge conflicts and integration issue. This can also lead to conflicting priorities when owners of different parts of the system want different things. 

Microservices allow us to assign part of a larger system, a microservice to a specific team. You have APIs where are communication points that you may need to collaborate with other teams on, most things should are now under the teams control. This makes them independent, and they are able to develop, test, deploy, and manage their application independently. 

### DevOp #

Managing deployments of may applications can be difficult. I've been on projects where a single deployment would take teams of people an entire weekend to complete. Now we need to deploy and manage tens of services, and have the knowledge of how to deploy each service. This is a lot more complicated because we are now deploying a lot more services. More services equals more deployments. However deployments are repeatable. And what is good at doing repeatable tasks the same way over and over again, Computer. 

We develop deployment pipeline that allow us to easily deploy these services, over and over again, as needed. 

DevOps is more than just the development and deployment, it is also Operations. Operating these systems became a lot more difficult. With a monolithic system you know where to go look for the logs. Now a single call could call multiple services. This can make trouble shooting microservices more difficult. So we introduce telemetry and log management systems into tech stack. This allow us to easily trace calls, using a correlation id, across multiple services. And we gather all of this data up into a single system that lets us quickly understand how the system is operating, and where failures may be coming from. 

### Containerization #

Containerization and especially container orchestrators, and microservice are a perfect fit, almost like they were made for each other, like peanut butter and chocolate. Containers are a way to package up your code, and dependencies, including the application runtime. Those containers can be quickly deployed anywhere and they should run exactly the same. 

Container Orchestrators, like Kubernetes, can handle a lot of thing for microservice like, routing, load balancing, service discovery, fault isolation, and container management.

# Moving from monolith to microservice #

Use the monolith as the default - Sam Newman, Martin Fowler

There are two ways two key ways to modernize an application: big bang and iterative. Big bang modernization is where you replace large parts or even the entire application as one big release, one big change. You often work on these big changes for months or years before the user is able to use them. Iterative modernization is when you modernize the application mostly in place with small little releases, and the application slowly evolves over time. This method allows us to deliver value to the user sooner, and allows us to pivot more if priorities change. We have a method for doing this, it is called the Strangler or Strangler Fig Pattern. 

The Strangler Fig Pattern was coined by Martin Fowler. The Stranger Fig is a plant that grows on trees. It slowly grows and replaces parts of the tree, piece by piece until it has enveloped the entire tree, and the tree dies. In our case this is what we do with a monolithic application. 

## First lets talk about domains #

So how do we know how to break up a monolithic application? Where should we draw the lines to split out. We use Domain Driven Design. 

Conway's Law: 
Any organization that designs a system (defined broadly) will produce a design whose structure is a copy of the organization's communication structure. — Melvin E. Conway

Domain driven design is a software approach where model software to match a business domain. Sometimes domains can be easily found by who the product owner is for that piece of an application. If one person is responsible for one piece of an application that is likely a domain. 

## Defining the API #

One of the most important parts of creating your microservice is defining the method with which it will communicate with all other services. Everything else is under the control of the microservice. I can change the underlying functionality, technology, then we have full control to manage that, but if we change the API, that affects every other service that calls that api.  


## De-tangling the data

One of the most complicated part of a lot of systems is the database. You have normalized data, foreign keys, stored procedures that execute multiple transaction. Lots of tangles reaching into different areas in the database. One of the key tenants of microservice is that each microservice keeps and manages its own data. The data could be stored in different databases, on different servers, using different technologies. Some could store their data as SQL, some as No-SQL. So we need to separate the data, a good start is to put the new tables in a new schema as a first layer of separation. If you need to keep transactions across multiple services you need to utilize Sagas, but that in its self is a large topic. 

## Setting up a facade # 

Now we need to isolate this section as its own domain. First we can separate the application creating a new package and moving the code for that domain into the new package. We can then quickly look for references to that code. Once you have separated out the domain code for you service you set up a facade. If you are going to use RESTful web calls to communicate with your services, you set up your REST controller and services to access the functionality with in the new service. Then to access that functionality you call those RESTful controllers using the API you developed. 

You can also setup an API gateway in front of the microservices to give you greater flexibility. 

## Stand Alone Service #

Now we can pull the service out by itself. You should be able to develop, test, deploy, and operate this application independently. 

You can also setup an API gateway in front of the microservices to give you greater flexibility. 

 
## User interface #

The user interface should be its own component, which reaches to other service. Now that calls are to API, you can have multiple user interfaces calling the same services, like web and mobile applications. 

There is also the potential to split the User interface into micro-front ends. As with microservices, you should start with a monolith and break them up, iteratively, as needed.  

## Conclusion #

I hope you learn about what microservices are: collection of independent, loosely-coupled, highly-cohesive services that communication with each other over a well defined protocol

When you should use them:
1. Need to be able to scale different parts of an application at a specific time
1. Multiple teams working on an application and getting in each others way
1. Fault isolation and high availability 
1. Technology diversity

And how to spit them up:
- Iteratively
- Define Domains
- Separate out the code
- Develop APIs
- Setup the facade
- De-tangle the data
- Separate the Service
