package parser.visitors.function;


import execution.state.ExecutionState;
import execution.state.StateFactory;
import execution.state.function.BuiltInFunctionState;
import execution.state.function.BuiltInMethodState;
import grammar.alkBaseVisitor;
import grammar.alkParser;
import parser.env.Environment;
import util.Payload;

public class FunctionCallVisitor extends alkBaseVisitor {

    private Environment env;

    private Payload payload;

    public FunctionCallVisitor(Environment env)
    {
        this.env = env;
    }

    public FunctionCallVisitor(Environment env, Payload payload)
    {
        this.env = env;
        this.payload = payload;
    }

    public Environment getEnvironment()
    {
        return env;
    }

    @Override
    public ExecutionState visitBuiltinFunction(alkParser.BuiltinFunctionContext ctx)
    {
        return StateFactory.create(BuiltInFunctionState.class, ctx, payload, env);
    }

    @Override
    public ExecutionState visitBuiltinMethod(alkParser.BuiltinMethodContext ctx)
    {
        return StateFactory.create(BuiltInMethodState.class, ctx, payload, env);
    }

    @Override public Object visitDefinedFunctionCall(alkParser.DefinedFunctionCallContext ctx)
    {
        /*try {
            AlkFunction function = AlkFunction.get(ctx.ID().getText(), ctx.expression().size());
            ArrayList array = new ArrayList();
            for (int i=0; i<ctx.expression().size(); i++)
            {
                ExpressionVisitor expressionVisitor = new ExpressionVisitor(env);
                if (function.isOut(i))
                {
                    String nume = ctx.expression(i).getText();
                    if (!env.has(nume))
                        throw new AlkException(ERR_PARAM_NOT_DEFINED);
                    array.add(new AlkInt(env.getLocation(nume)));
                }
                else
                {
                    AlkValue val = (AlkValue) expressionVisitor.visit(ctx.expression(i));
                    array.add(val.clone());
                }
            }
            return function.call(array);
        } catch (AlkException e) {
            e.printException(ctx.start.getLine());
            return new AlkBool(false);
        }*/
        return null;
    }
}