# Drug Supply Chain System

Our project is about Drug Supply Chain System. The working of our project is as follows: 

These events are not dependent on each other – 

1. Initially, the State Health Department Admin adds the population of a created state. 
2. The manufacturer manufactures a particular drug. 
3. The FDA (Food and Drug Administration) officer places an order for a drug to the manufacturer. 
4. Providers (hospital provider/remote clinic provider) place an order for a drug that they need.

The events mentioned below happen in sequence –  

1. First, the manufacturer ships the drug ordered by the FDA to a distributor. 
2. The distributor then stores this drug in a warehouse. 
3. If the remote clinic provider has placed a request for a particular drug, this order first needs to be approved by the hospital provider. Then it follows the same sequence as below. 
4. The State Health Department admin approves the order placed by the providers. 
5. This order then needs to be approved by the FDA officer. 
6. Once the order is approved by the FDA officer, the distributor is permitted to ship the same to the providers.  
7. The providers add the received drugs to their inventory. 
8. The providers can then administer this drug to the patients. 

ObjectModel.png

