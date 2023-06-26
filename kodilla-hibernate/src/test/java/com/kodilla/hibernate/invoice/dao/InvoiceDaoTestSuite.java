package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testFindByName() {

        //Given
        String invoiceName = "invoice001";
        Invoice tested = new Invoice(invoiceName);
        invoiceDao.save(tested);

        //When
        List<Invoice> testedList = invoiceDao.findByName(invoiceName);

        //Then
        assertEquals(1, testedList.size());
        assertEquals(tested, testedList.get(0));

        //CleanUp
        int id = testedList.get(0).getId();
        invoiceDao.deleteById(id);
    }

    @Test
    void testOneToManyToMany() {

        //Given
        Product pencil = new Product("pencil");
        Product notebook = new Product("notebook");
        Item item1 = new Item(pencil, new BigDecimal(5), 2);
        Item item2 = new Item(pencil, new BigDecimal(5), 4);
        Item item3 = new Item(notebook, new BigDecimal(7), 1);
        pencil.getItems().add(item1);
        pencil.getItems().add(item2);
        notebook.getItems().add(item3);

        Invoice invoice001 = new Invoice("001");
        invoice001.getItems().add(item1);
        invoice001.getItems().add(item2);
        invoice001.getItems().add(item3);
        item1.setInvoice(invoice001);
        item2.setInvoice(invoice001);
        item3.setInvoice(invoice001);

        //When
        invoiceDao.save(invoice001);
        int notebookId = notebook.getId();
        int item3Id = item2.getId();
        int invoice001Id = invoice001.getId();

        //Then
        assertNotEquals(0, notebookId);
        assertNotEquals(0, item3Id);
        assertNotEquals(0, invoice001Id);
        assertEquals(2, pencil.getItems().size());
        assertEquals(3, invoice001.getItems().size());

        //ClearUp
        try {
            invoiceDao.deleteById(invoice001Id);
        } catch (Exception e) {
            //do nothing
        }
    }
}