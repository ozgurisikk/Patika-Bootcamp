import React, { createContext, useState } from "react";

export const MoneyContext = createContext();

export const MoneyProvider = ({ children }) => {
    const [money, setMoney] = useState(100000000000);
 
    return (
        <MoneyContext.Provider value={{ money, setMoney }}>
            {children}
        </MoneyContext.Provider>
    );
};
