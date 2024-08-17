const data = {
    avatar: "https://picsum.photos/150",
    name: "John Doe", 
    phoneNumbers: [

        { name: "home", number: "123456789" },
        { name: "work", number: "987654321" },
    ],
    addresses: [
        { name: "home", address: "1234 Main St"},
        { name: "work", address: "5678 Main St"}
    ],
    emails: [
        { name: "personal", email: "john@doe.co"}, 
        { name: "work", email: "john@acme.com" } 
    ],
};

const Person = () => {
    return(
        <div className="person">
            <div className="side">
            <img className="person-avatar" src={data.avatar} alt={data.name} />
            <h1 className="person-name">{data.name}</h1>
            </div>
            <div className="info">

            
            <div className="person-list-entry">
                <h2 className="list-type">Phone Numbers</h2>
                <ul >
                    {data.phoneNumbers.map((phoneNumberItem)=>{
                        return <li key={phoneNumberItem.name}>
                            <span className="list-label">{phoneNumberItem.name}</span> 
                            <span className="list-value">{phoneNumberItem.number}</span>
                        </li>
                    })}
                </ul>
            </div>
            <div className="person-list-entry">
                <h2 className="list-type">Addresses</h2>
                <ul >
                    {data.addresses.map((addressItem)=>{
                        return <li key={addressItem.name}>
                            <span className="list-label">{addressItem.name}</span> 
                            <span className="list-value">{addressItem.address}</span>
                        </li>
                    })}
                </ul>
            </div>
            <div className="person-list-entry">
                <h2 className="list-type">E-Mails</h2>
                <ul >
                    {data.emails.map((emailItem)=>{
                        return <li key={emailItem.name}>
                            <span className="list-label">{emailItem.name}</span> 
                            <span className="list-value">{emailItem.email}</span>
                        </li>
                    })}
                </ul>
            </div>
        </div>
        </div>
    )
}
 
export default Person;