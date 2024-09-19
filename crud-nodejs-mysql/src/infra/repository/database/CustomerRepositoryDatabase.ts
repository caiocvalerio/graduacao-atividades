import knex, { Knex } from "knex";
import { Customer } from "../../../model/Customer";
import { CustomerRepository } from "../../../model/repository/CustomerRepository";
import { environment } from "./KnexConfig";
import { Uuid } from "../../../model/Uuid";
import { CustomerUpdateDTO } from "../../../controller/dtos/CustomerUpdateDTO";

export class CustomerRepositoryDatabase implements CustomerRepository {
    private connection: Knex
    
    constructor() {
        this.connection = knex(environment)
    }
    
    async save(customer: Customer): Promise<void> {
        await this.connection('customer').insert({
            'id': customer.getId().getValue(),
            'name': customer.getName(),
            'document': customer.getDocument().getValue()
        })
    }

    async getAll(): Promise<Customer[]> {
        const customerCollection: Array<Customer> = []
        const customers = await this.connection('customer').select('*')
        
        for(var i=0; i < customers.length; i++) {
            customerCollection.push(Customer.create(customers[i]['name'], customers[i]['document'], customers[i]['id']))
        }
        
        return customerCollection
    }

    async getById(id: Uuid): Promise<Customer> {
        const customer: any = await this.connection('customer').select('*').where({'id':id.getValue()})

        if (!customer) {
            throw new Error('Customer '+ id.getValue() +' not found')
        }

        return Customer.create(customer[0]['name'], customer[0]['document'], customer[0]['id'])
    }

    async removeById(id: Uuid): Promise<void> {
        await this.connection('customer').where({'id': id.getValue()}).delete() 
    }

    async updateById(id: Uuid, customerDTO: CustomerUpdateDTO): Promise<Customer> {
        await this.connection('customer').where({'id': id.getValue()}).update({
            'name': customerDTO.name,
            'document': customerDTO.document 
        })
        return await this.getById(id)
    }

}