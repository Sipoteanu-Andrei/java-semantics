package impl.types.alkInt;

import impl.exceptions.AlkException;
import impl.exceptions.InterpretorException;
import impl.types.AlkValue;
import impl.types.alkBool.AlkBool;
import impl.types.alkDouble.AlkDouble;
import impl.types.alkString.AlkString;

import java.math.BigInteger;

import static impl.exceptions.AlkException.*;
import static impl.exceptions.InterpretorException.ERR_VALUE_TYPE_UNRECOGNIZED;

public class BitwiseIntHelper {

    private BigInteger value;

    BitwiseIntHelper(BigInteger value)
    {
        this.value = value;
    }

    AlkValue bitwiseAnd(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_BITWISEAND_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return bitwiseAnd(((AlkInt)operand));
            case "Double": return bitwiseAnd((AlkDouble)operand);
            case "String": return bitwiseAnd((AlkString)operand);
            case "Bool": return bitwiseAnd((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt bitwiseAnd(AlkInt operand)
    {
        return new AlkInt(value.and(operand.value));
    }

    private AlkDouble bitwiseAnd(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_BITWISEAND_DOUBLE);
    }

    private AlkInt bitwiseAnd(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_BITWISEAND_BOOL);
    }

    private AlkInt bitwiseAnd(AlkString operand) throws AlkException {
        throw new AlkException(ERR_BITWISEAND_STRING);
    }


    AlkValue bitwiseOr(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_BITWISEOR_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return bitwiseOr(((AlkInt)operand));
            case "Double": return bitwiseOr((AlkDouble)operand);
            case "String": return bitwiseOr((AlkString)operand);
            case "Bool": return bitwiseOr((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt bitwiseOr(AlkInt operand)
    {
        return new AlkInt(value.or(operand.value));
    }

    private AlkDouble bitwiseOr(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_BITWISEOR_DOUBLE);
    }

    private AlkInt bitwiseOr(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_BITWISEOR_BOOL);
    }

    private AlkInt bitwiseOr(AlkString operand) throws AlkException {
        throw new AlkException(ERR_BITWISEOR_STRING);
    }


    AlkValue bitwiseXor(AlkValue operand) throws AlkException, InterpretorException
    {
        if (operand.isDataStructure)
            throw new AlkException(ERR_BITWISEXOR_DATA_STRUCTURE);
        switch(operand.type)
        {
            case "Int": return bitwiseXor(((AlkInt)operand));
            case "Double": return bitwiseXor((AlkDouble)operand);
            case "String": return bitwiseXor((AlkString)operand);
            case "Bool": return bitwiseXor((AlkBool)operand);
        }
        throw new InterpretorException(ERR_VALUE_TYPE_UNRECOGNIZED);
    }

    private AlkInt bitwiseXor(AlkInt operand)
    {
        return new AlkInt(value.xor(operand.value));
    }

    private AlkDouble bitwiseXor(AlkDouble operand) throws AlkException {
        throw new AlkException(ERR_BITWISEXOR_DOUBLE);
    }

    private AlkInt bitwiseXor(AlkBool operand) throws AlkException {
        throw new AlkException(ERR_BITWISEXOR_BOOL);
    }

    private AlkInt bitwiseXor(AlkString operand) throws AlkException {
        throw new AlkException(ERR_BITWISEXOR_STRING);
    }


}
