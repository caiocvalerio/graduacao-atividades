import { Cnpj } from "./Cnpj"
import { Cpf } from "./Cpf"
import { IdentificationDocument } from "./IdentificationDocument"

export class IdentificationDocumentFactory {
    static create(value: string): IdentificationDocument {
        if(Cpf.isValid(value)) {
            return new Cpf(value)
        }

        if(Cnpj.isValid(value)) {
            return new Cnpj(value)
        }

        throw new Error("Entered document invalid.")
    }
}