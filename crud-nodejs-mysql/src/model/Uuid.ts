import {validate, v4} from "uuid"

export class Uuid {
    private value: string
    
    constructor(value: string) {
        if(!validate(value)) {
            throw new Error("Value (" +value+ ") is not valid.")
        }
        this.value = value
    }

    static randomUuid(): Uuid {
        return new Uuid(v4())
    }

    public getValue(): string {
        return this.value
    }

}