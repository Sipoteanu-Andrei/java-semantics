package execution.parser.env;

import util.types.Storable;

import java.util.HashMap;
import java.util.Map;


public class EnvironmentProxy implements Environment
{
    protected Map<String, Location> variables = new HashMap<>();
    Environment target;
    StoreImpl store;

    public EnvironmentProxy(Environment e)
    {
        this.target = e;
        this.store = e.getStore();
    }

    public void addTempEntry(String id, Storable value)
    {
        if (variables.containsKey(id))
            store.set(variables.get(id), value);
        else
            variables.put(id, store.malloc().assign(value));
    }

    @Override
    public Location getLocation(String id)
    {
        if (variables.containsKey(id))
        {
            return variables.get(id);
        }
        else
        {
            return target.getLocation(id);
        }
    }

    @Override
    public void setLocation(String name, Location location)
    {
        target.setLocation(name, location);
    }

    public Location define(String id)
    {
        return target.define(id);
    }

    @Override
    public void update(String id, Storable value)
    {
        target.update(id, value);
    }

    @Override
    public boolean has(String id) {
        return target.has(id) || variables.containsKey(id);
    }

    @Override
    public Environment makeClone(LocationMapper locMapping, StoreImpl store)
    {
        EnvironmentProxy copyEnv = new EnvironmentProxy(target);
        for (Map.Entry<String, Location> entry : variables.entrySet())
            copyEnv.variables.put(entry.getKey(), locMapping.get(entry.getValue()));
        return copyEnv;
    }

    @Override
    public StoreImpl getStore()
    {
        return store;
    }
}
