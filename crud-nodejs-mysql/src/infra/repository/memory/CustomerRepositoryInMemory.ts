import { CustomerUpdateDTO } from "../../../controller/dtos/CustomerUpdateDTO"
import { Customer } from "../../../model/Customer"
import { CustomerRepository } from "../../../model/repository/CustomerRepository"
import { Uuid } from "../../../model/Uuid"

export class CustomerRepositoryInMemory implements CustomerRepository {
    updateById(id: Uuid, customerDTO: CustomerUpdateDTO): Promise<Customer> {
        throw new Error("Method not implemented.")
    }
    removeById(id: Uuid): Promise<void> {
        throw new Error("Method not implemented.")
    }
    getById(id: Uuid): Promise<Customer> {
        throw new Error("Method not implemented.")
    }
    
    async getAll(): Promise<Customer[]> {
        return this.customerCollection
    }
    
    private customerCollection: Array<Customer> = []

    async save(customer: Customer): Promise<void> {
        this.customerCollection.push(customer)
    }

}