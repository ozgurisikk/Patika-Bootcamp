import { useContext } from "react";
import { MoneyContext } from "../context/MoneyContext";

function Money() {
    const { money } = useContext(MoneyContext);

    return (
        <div className="money-header">
            <h1>${money}</h1>
        </div>
    );
}

export default Money;
