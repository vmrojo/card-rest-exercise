package com.snou.firstdata.service.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snou.firstdata.service.CardPaymentService;
import com.snou.firstdata.service.exception.ApplicationException;
import com.snou.firstdata.service.payment.model.CardBrandEnum;
import com.snou.firstdata.service.payment.model.CardInfo;
import com.snou.firstdata.service.payment.model.OperationRate;
import com.snou.firstdata.service.payment.model.PaymentOperation;
import com.snou.firstdata.service.resource.CardInfoResource;
import com.snou.firstdata.service.resource.OperationRateResource;
import com.snou.firstdata.service.resource.PaymentOperationResource;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/payment", produces = "application/json")
public class CardPaymentController {

    @Autowired
    private CardPaymentService cardPaymentService;
    
    public CardPaymentService getCardPaymentService() {
        return cardPaymentService;
    }
    
    public void setCardPaymentService(CardPaymentService cardPaymentService) {
        this.cardPaymentService = cardPaymentService;
    }
    
    @RequestMapping(value="/card", method = RequestMethod.POST)
    public ResponseEntity<CardInfoResource> findCardById(@RequestBody CardInfo card) {
        boolean valid = cardPaymentService.isValidCard(card);
        if(valid) {
            card = cardPaymentService.saveCardInfo(card);
            return new ResponseEntity<>(new CardInfoResource(card), HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="/card/{id}", method = RequestMethod.GET)
    public ResponseEntity<CardInfoResource> findCardById(@PathVariable Long id) {
        CardInfo card;
        try {
            card = cardPaymentService.retrieveCardInfo(id);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(new CardInfoResource(card), HttpStatus.OK);
    }
    
    @RequestMapping(value="/validateOperation", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<PaymentOperationResource> validateOperation(@RequestBody PaymentOperation operation) {
        boolean valid = cardPaymentService.isValidPaymentOperation(operation.getAmount());
        if(valid) {
            return new ResponseEntity<>(new PaymentOperationResource(operation), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(new PaymentOperationResource(operation), HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="/validateCard", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<CardInfoResource> validateCard(@RequestBody CardInfo card) {
        boolean valid = cardPaymentService.isValidCard(card);
        if(valid) {
            return new ResponseEntity<>(new CardInfoResource(card), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(new CardInfoResource(card), HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="/rate", method = RequestMethod.GET)
    public ResponseEntity<OperationRateResource> findOperationRate(@RequestParam("brand") String brand,
                                                                   @RequestParam("amount") String amount) {
        BigDecimal opAmount = new BigDecimal(amount);
        CardBrandEnum cardBrand;
        
        try {
            cardBrand = CardBrandEnum.valueOf(brand);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        
        OperationRate rate;
        try {
            rate = cardPaymentService.retrieveOperationRate(cardBrand, opAmount);
        } catch (ApplicationException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        OperationRateResource r = new OperationRateResource();
        r.setBrand(cardBrand);
        r.setAmount(opAmount);
        r.setRate(rate.calculateRate());
        
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
    
}
