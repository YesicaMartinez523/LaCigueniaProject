import { InvoiceModel } from "@commons/domains/invoice/InvoiceModel";
import { UseCase } from "@commons/helpers/UserCase";
import { InvoiceRepository } from "@repository/invoice/InvoiceRepository";
import { Observable } from "rxjs";
import { GenericResponse } from "@commons/response/GenericResponse";

export class ReadInvoiciesUseCase implements UseCase<InvoiceModel, GenericResponse>{

    constructor(private invoiceRepository: InvoiceRepository){}

    execute() : Observable<GenericResponse>{
        return this.invoiceRepository.readInvoicies();
    }
}