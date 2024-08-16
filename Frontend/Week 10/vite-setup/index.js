const person = {
    name : "John",
    age: 25,
    isMarried : false,
    children : ["Anna", "Peter"],
    job: {
        title: "Frontend",
        company: {
            name: "Google",
            ceo: {
                name:"Sundar",
                age: 50,
                isMarried: true,
            }

        }
    }
}

const person2 = {...person, job: {...person.job, company: {...person.job.company, ceo: {...person.job.company.ceo}}} }
person2.job.title = "baska is"

person2.name= "ozgur"
person2.job.company.name = "Facebook"
person2.job.company.ceo.name = "oflii"

const {isMarried, ...theRestOfPerson} = person;



