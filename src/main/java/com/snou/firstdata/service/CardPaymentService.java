package com.snou.firstdata.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import com.snou.firstdata.service.dao.Dao;
import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardBrandEnum;
import com.snou.firstdata.service.payment.model.CardInfo;
import com.snou.firstdata.service.payment.model.OperationRate;
import com.snou.firstdata.service.payment.model.PaymentOperation;
import com.snou.firstdata.service.payment.validation.Validator;

@Service
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "payment")
public class CardPaymentService {

    @Autowired
    private Dao<CardInfo> cardDao;
    @Autowired
    private Dao<PaymentOperation> operationDao;
    
    @Autowired
    private Validator cardValidator;
    @Autowired
    private Validator operationValidator;
    
    private HashMap<String, String> rates;
    
    public CardPaymentService() {

    }

    public Dao<CardInfo> getCardDao() {
        return cardDao;
    }
    
    public Dao<PaymentOperation> getOperationDao() {
        return operationDao;
    }
    
    public Validator getCardValidator() {
        return cardValidator;
    }
    
    public Validator getOperationValidator() {
        return operationValidator;
    }
    
    public HashMap<String, String> getRates() {
        return rates;
    }
    
    public void setCardDao(Dao<CardInfo> cardDao) {
        this.cardDao = cardDao;
    }
    
    public void setOperationDao(Dao<PaymentOperation> operationDao) {
        this.operationDao = operationDao;
    }
    
    public void setCardValidator(Validator cardValidator) {
        this.cardValidator = cardValidator;
    }
    
    public void setOperationValidator(Validator operationValidator) {
        this.operationValidator = operationValidator;
    }
    
    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }

    public CardInfo saveCardInfo(CardInfo card) {
        return cardDao.create(card);
    }
    
    public CardInfo retrieveCardInfo(Long cardId) throws ApplicationException{
        Optional<CardInfo> card = cardDao.findById(cardId);
        if(card.isPresent()) {
            return card.get();
        }
        else {
            throw new ApplicationException("Card info not found");
        }
    }
    
    public OperationRate retrieveOperationRate(CardBrandEnum brand, BigDecimal amount) throws ApplicationException{
        String rateClass = rates.get(brand.getBrand());
        
        Object instance;
        try {
            instance = Class.forName(rateClass).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new ApplicationException(e);
        }
        
        return (OperationRate) instance;
    }
    
    public boolean isValidPaymentOperation(BigDecimal amount) {
        PaymentOperation op = new PaymentOperation(amount);
        
        boolean isValid = false;
        try {
            operationValidator.validate(op);
            isValid = true;
        } catch (ApplicationException e) {
            // log
        }
        
        return isValid;
    }
    
    public boolean isValidCard(CardInfo card) {
        boolean isValid = false;
        try {
            cardValidator.validate(card);
            isValid = true;
        } catch (ApplicationException e) {
            //log
        }
        
        return isValid;
    }
    
    public boolean cardsMatch(CardInfo card1, CardInfo card2) {
        return card1.equals(card2);
    }
    
    public void executePayment(PaymentOperation payment, CardInfo card) throws ApplicationException{
        
        cardValidator.validate(card);
        operationValidator.validate(payment);

        try {
            printReceipt(payment);
        }
        catch (ApplicationException e) {
            // log
            // set to retry at a later time or allow a reprint
        }
        
        sendCardInfo(card);
        
        try {
            sendPaymentNotification(payment);
        }
        catch (ApplicationException e) {
            // log
            // set to retry at a later time or reverse operation
        }
        
        try {
            updateBalance();
        }
        catch (ApplicationException e) {
            // log
            // set update as pending
        }
        
    }
    
    private void printReceipt(PaymentOperation payment) throws ApplicationException{
        System.out.println("print receipt");    //imprimir factura en controladora fiscal
    }
    
    private void sendCardInfo(CardInfo card) throws ApplicationException{
        System.out.println("send card info");    //enviar info de tarjeta de credito
    }
    
    private void sendPaymentNotification(PaymentOperation payment) throws ApplicationException{ 
        System.out.println("send payment notification");    //informar pago a comercial
    }
    
    private void updateBalance() throws ApplicationException{
        System.out.println("update customer's balance");    //actualizar saldo del cliente
    }
}
