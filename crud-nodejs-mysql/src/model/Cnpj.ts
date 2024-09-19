import { IdentificationDocument } from "./IdentificationDocument"

export class Cnpj implements IdentificationDocument {

    private value: string

    constructor(value: string) {
        if(!Cnpj.isValid(value)){
            throw new Error("Entered CPNJ (" + value+  ")incorret.")
        }
        this.value = value
    }

    static isValid(value: string): boolean {
        return value.length == 14
    }

    getDocument(): IdentificationDocument {
        return this
    }
    getValue(): string {
        return this.value
    }
    
}