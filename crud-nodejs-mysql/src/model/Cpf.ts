import { IdentificationDocument } from "./IdentificationDocument"

export class Cpf implements IdentificationDocument {

    private value: string

    constructor(value: string) {
        if(!Cpf.isValid(value)){
            throw new Error("Entered CPF (" + value + ") incorret.")
        }
        this.value = value
    }

    static isValid(value: string): boolean {
        return value.length == 11
    }

    getDocument(): IdentificationDocument {
        return this
    }
    getValue(): string {
        return this.value
    }
    
}