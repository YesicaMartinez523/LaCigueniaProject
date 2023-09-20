package LaCiguenia.commons.domains.wrapper;

import java.time.LocalDate;

public interface DetailProductForInvoice {
    Integer getInvoiceId();
    LocalDate getInvoiceDate();
    String getCustomerName();
    String getCustomerIdentification();
    String getProductName();
    Double getProductPrice();
    Integer getDetailAmount();
    Integer getProductIva();
    Double getDetailSubtotal();
    Double getInvoiceIva();
    Double getInvoiceTotal();
}