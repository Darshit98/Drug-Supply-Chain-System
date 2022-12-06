/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Network;

import Business.Enterprise.LocalHealthDepartment;
import java.util.ArrayList;

/**
 *
 * @author swinirodrigues
 */

public class StateNetwork {
    
    private ArrayList<CityNetwork> cityList;
    private LocalHealthDepartment localHealthDepartment;
    private String stateName;
    private int statePopulation;
    private int vaccinesLeftForState;
    
    public StateNetwork() {
        
        this.cityList = new ArrayList<>();
        localHealthDepartment = new LocalHealthDepartment(stateName);
        statePopulation = 0;
        vaccinesLeftForState = statePopulation;
    }

    public int getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(int statePopulation) {
        this.statePopulation = statePopulation;
    }

    public int getVaccinesLeftForState() {
        return vaccinesLeftForState;
    }

    public void setVaccinesLeftForState(int vaccinesLeftForState) {
        this.vaccinesLeftForState = vaccinesLeftForState;
    }
    
    public ArrayList<CityNetwork> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<CityNetwork> cityList) {
        this.cityList = cityList;
    }

    public LocalHealthDepartment getLocalHealthDepartment() {
        return localHealthDepartment;
    }

    public void setLocalHealthDepartment(LocalHealthDepartment localHealthDepartment) {
        this.localHealthDepartment = localHealthDepartment;
    }
    
           
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public CityNetwork addNewCity(String name){
        
        CityNetwork cn = new CityNetwork();
        cn.setName(name);
        cityList.add(cn);
        return cn;
        
    }
    
    public void removeCity(CityNetwork city){
        
        cityList.remove(city);
    }
    
  //Dispalys number of vaccines administered in State
    
    public int getTotalVaccinesAdministeredInState(){
        int sum = 0;
        if(cityList != null)
        {
            for(CityNetwork city: cityList)
            {
                sum= sum+city.getTotalVaccinesAdministeredInCity();
            }
        }
        return sum;

    }
    
     //Dispalys number of failed vaccines administered in State
    
     public int getTotalFailedVaccinesInState(){
        int sum = 0;
        if(cityList != null)
        {
            for(CityNetwork c: cityList)
            {
                sum= sum+c.getTotalFailedVaccinesInCity();
            }
        }
        return sum;

    }
     
     //Dispalys number of failed vaccines distributed in State
     
      public int getTotalVaccinesDistributedInState(){
        int sum = 0;
        if(cityList != null)
        {
            for(CityNetwork c: cityList)
            {
                sum= sum+c.getTotalVaccinesDistributedInCity();
            }
        }
        return sum;
        
    }


    @Override
    public String toString() {
        return stateName;
    }

}
