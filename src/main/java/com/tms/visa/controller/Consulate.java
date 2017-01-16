package com.tms.visa.controller;

import com.tms.visa.bean.ContinentsEnum;

import com.tms.visa.model.ConsulateEntity;
import com.tms.visa.model.CountryEntity;
import com.tms.visa.service.ConsulateService;
import com.tms.visa.service.CountryService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Test-Lab on 2016/6/29.
 */

@Controller
@RequestMapping("/")
@SessionAttributes("consulate")
public class Consulate {
    @Resource
    private ConsulateService consulateService;
    @Resource
    private CountryService countryService;

    private String result;
    private static CountryEntity countryEntity;
    private ConsulateEntity consulateEntity;

    public Consulate(){
        consulateEntity = new ConsulateEntity();

    }
    public int getInterContinental() {
        return selectIndex;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public void addConsulate(ActionEvent evt) {
        consulateEntity.setId(consulateService.getKeyValue());
        consulateEntity.setCountryId(countryEntity.getId());
        try {

            consulateService.addCountry(consulateEntity);

            result = "Create country successfully";
        } catch (Exception e) {
            e.printStackTrace();
            result = "Create country unsuccessfully";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, null, result);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DataModel getListConsulate() {
        return new ListDataModel(consulateService.findAllConsulate());
    }

    public DataModel getListConsulateForCountry(Long id) {
        return new ListDataModel(consulateService.findConsulateByCountry(id));
    }

    public void delConsulate(){
        consulateService.deleteConsulateById(consulateEntity.getId());
    }

    public List<SelectItem> getSelectItemList() {
        List<SelectItem> selectItemList = new ArrayList<SelectItem>();
        for (int index = 1; index < 8; index++) {
            ContinentsEnum.getName(index);
            selectItemList.add(new SelectItem(index, ContinentsEnum.getName(index)));
        }
        return selectItemList;
    }

    public String getContinentValue(int index) {
        return ContinentsEnum.getName(index);

    }

    public void updateCountry(){
        try {
            consulateEntity.setCountryId(countryEntity.getId());
            consulateService.updateCountry(consulateEntity);

            result = "Update successfully";
        } catch (Exception e) {
            e.printStackTrace();
            result = "Update unsuccessfully";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, null, result);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    private int selectIndex = 1;

    public void selectChange(ValueChangeEvent event) {
        selectIndex = Integer.parseInt((String) selectone.getValue());
    }

    boolean editable;

    public boolean isEditable() {
        return editable;
    }
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String editAction(CountryEntity countryEntity) {
        Consulate country= new Consulate();
        country.setEditable(true);

        return null;
    }

    public String saveAction() {
        return null;

    }

    public ConsulateEntity getConsulateEntity() {
        return consulateEntity;
    }

    public ConsulateEntity getEntity(){

        FacesContext fc = FacesContext.getCurrentInstance();
        Map requestParams = fc.getExternalContext().getRequestParameterMap();
        if( requestParams.containsKey("Id")){
            if(consulateEntity!=null && consulateEntity.getId()==0){
                String id = (String) requestParams.get("Id");
                consulateEntity = consulateService.findConsulateId(new Long(id));
            }
        }
        if (requestParams.containsKey("countryId")){

            String countryid = (String) requestParams.get("countryId");
            countryEntity = new CountryEntity();
            countryEntity=countryService.findCountryId(Long.valueOf(countryid));

            consulateEntity.setCountryEntity(countryEntity);
        }
        if( requestParams.containsKey("consulateId")){

                String id = (String) requestParams.get("consulateId");
                consulateEntity = consulateService.findConsulateId(new Long(id));


        }
        return consulateEntity;
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setConsulateEntity(ConsulateEntity consulateEntity) {
        this.consulateEntity = consulateEntity;
    }

    public void setCountryEntity(CountryEntity countryEntity) {
        this.countryEntity = countryEntity;
    }


}
