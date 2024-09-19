import { IdentificationDocumentFactory } from "./IdentifcationDocumentFactory"
import { IdentificationDocument } from "./IdentificationDocument"
import { Uuid } from "./Uuid"

export class Customer {
    private id: Uuid
    private name: string
    private document: IdentificationDocument

    constructor(name: string, document: IdentificationDocument, id?: string) {
        this.id = id? new Uuid(id) : Uuid.randomUuid()
        this.name = name
        this.document = document
    }

    static create(name: string, document: string, id?: string): Customer {
        const currentDocument =  IdentificationDocumentFactory.create(document)
        return new Customer(name, currentDocument, id)
    }

    public getId(): Uuid {
        return this.id
    }
    
    public getName(): string {
        return this.name
    }

    public getDocument(): IdentificationDocument {
        return this.document
    }
}