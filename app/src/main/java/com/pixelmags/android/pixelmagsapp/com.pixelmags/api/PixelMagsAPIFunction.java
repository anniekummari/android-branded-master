package com.pixelmags.android.pixelmagsapp.com.pixelmags.api;

/**
 * Created by Annie on 22/09/15.
 */

import java.text.DateFormat;
import java.util.Date;

/**
 * Base class for a PixelMags API function.
 *
 * <p>To define a new function, implement a class that extends PixelMagsAPIFunction following these
 * guidelines:</p>
 *
 * <ul>
 * 	<li>Create a constructor without parameters and call the parent constructor with appropriate parammeters to configure the function.</li>
 * 	<li>Optionally implement any setters to add API function parameters in a type safe way.</li>
 * 	<li>If the function does not follow the specification for returning the result in the 'data' parameter (which is the case
 * for almost all functions!), override the 'parseResult' method.</li>
 * </ul>
 *
 * @author annie
 *
 */
public class PixelMagsAPIFunction {

    /**
     * Constructor. Configures the function with the specified parameters.
     *
     * <p>Functions that do not return the result in the JSON format must set 'getRawResult' to true.
     * In this case, the result received from the server is not parsed and passed as is to the 'parseResult' function.</p>
     *
     * @param name Name of the API function as expected by the server.
     * @param requireAuth Specifies if this function requires authentication.
     * @param getRawResult Specifies if the result of the function call should be passed as is to the 'parseResult' function.
     *
     */
    public void PixelMagsAPIFunction(String name, Boolean requireAuth, Boolean getRawResult = false)
    {
        this._name = name;
        this._requieAuthentication = requireAuth;
        this._getRawResult = getRawResult;
    }
    private String _name;

    /**
     * Returns the API function name.
     */
    public String name()
    {
        return _name;
    }

    private Object _parameters = new Object();

    /**
     * Defines the function parameters object. The parameter names must have the format expected by the server.
     */
    public Object parameters()
    {
        return _parameters;
    }

    public void parameters(Object value)
    {
        _parameters = value == null ? new Object() : value;
    }

    private Boolean _requieAuthentication;

    /**
     * Tells if the function requires authentication.
     */
    public Boolean requieAuthentication()
    {
        return _requieAuthentication;
    }

    private Boolean _getRawResult;

    /**
     * Tells if the functions requires raw result.
     */
    public Boolean getRawResult()
    {
        return _getRawResult;
    }

    /**
     * Returns parameter value if defined, null otherwise.
     */
    public Object getParameter(String name)
    {
        if (name == null || name.length() == 0)
            return null;

        return  name;
        //return _parameters.hasOwnProperty(name) ? _parameters[name] : null;
    }

    /**
     * Sets the specified parameter with the specified value. Theparameter name must have the
     * format expected by the server.
     */
    public void setParameter(String name, String value)
    {
        if (name == null || name.length() == 0)
            return;

        name = value;
        //_parameters[name] = value;
    }

    /**
     * This function is called by PixelMagsAPI if the function succeeds. If 'getRawResult' is set to true,
     * the 'result' parameter will hold the result as received from the server, otherwise it holds the JSON result
     * parsed into an ActionScript object.
     *
     * <p>The default implementation returns the value of 'data' element if it is available, as defined by the specification.
     * API functions that do not return the result in the 'data' element should override this function
     * to extract and return the final result.</p>
     *
     * @param result JSON data returned by the API call converted to an ActionScript object.
     * @return Final result extracted from the specified result object.
     *
     */
    public Object parseResult(Object result)
    {
        Object data = null;

			/* Test for the existance of 'data' as some functions do not return it. */
       // if (result.hasOwnProperty("data"))
            //data = result.data;

        return data;
    }



}




