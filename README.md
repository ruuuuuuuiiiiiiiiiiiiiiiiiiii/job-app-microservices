# job-app-microservices

# Demo Local Machine Run
# Instruction to run on Kubernates for 
    - clone repository to get kubernetes (k8s) .yaml config, if no .yaml config provided create your own .yaml file
    - download and install minikube if run locally
    - start minikube on windows or docker
    - create pods, deployment, services from (k8s) .yaml config folder (images to be used should be pushed to docker hub always) (command: kubectl apply -f <(k8s) .yaml config folder path> or k8s .yaml config file path)
    - create database for every microservice (command: kubectl exec -it <nameOfPods> -- psql -d <DB to access> -U <user>, example: kubectl exec -it <nameOfPods> -- psql -d jobapp -U jobapp)
    - run DB query to create database, exit after succesful execution
    - run command minikube dasboard to easily check entire application run on kubernetes for any errors (note: if minikube dasboard is running terminal will be not accessible, open new terminal to run another command)
    - get k8s randomly generated URL used to run and test microservice (command: minikube  service <name of service> --url)
    - use URL acquire above and run and test API from the microservices
    - if you want to restart minikube just run minikube stop and minikube start, if minicube is started using docker you can use docker desktop to restart, pause or stop minikube
    - if you have a question about minikube or kubectl, just visit minikube or kubectl documentation https://minikube.sigs.k8s.io/docs/handbook/ 
    - end