package com.mytaxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.controller.mapper.SearchReport;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.datatransferobject.CarInput;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.datatransferobject.ResponseDTO;
import com.mytaxi.domainobject.UserDO;
import com.mytaxi.domainvalue.CarStatus;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.domainvalue.Ratings;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;
import com.mytaxi.service.car.UserService;
import com.mytaxi.service.driver.DriverService;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HomeController
{

    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarService carService;
    private UserDO loggedInUser;


    @RequestMapping(value = "swagger", method = RequestMethod.GET)
    public String getSwagger()
    {
        return "redirect:swagger-ui.html";
    }

    @RequestMapping(value = "help", method = RequestMethod.GET)
    public ModelAndView getHelp()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("help");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public ModelAndView registration()
    {
        ModelAndView modelAndView = new ModelAndView();
        UserDO user = new UserDO();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }


    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserDO user, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();
        UserDO userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null)
        {
            bindingResult.rejectValue(
                "email", "error.user",
                "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors())
        {
            modelAndView.setViewName("registration");
        }
        else
        {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserDO());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }


    @RequestMapping(value = "main", method = RequestMethod.POST)
    public ModelAndView mainLogin()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDO user = userService.findUserByEmail(auth.getName());
        loggedInUser = user;
        addLoggedInUserDetailsToView(modelAndView);
        modelAndView.setViewName("main");
        return modelAndView;
    }


    @RequestMapping(value = "main", method = RequestMethod.GET)
    public ModelAndView main()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDO user = userService.findUserByEmail(auth.getName());
        loggedInUser = user;
        addLoggedInUserDetailsToView(modelAndView);
        modelAndView.setViewName("main");
        return modelAndView;
    }


    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ModelAndView getUsers()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.getAllUsers());
        modelAndView.setViewName("users");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "driverdatas/add", method = RequestMethod.GET)
    public ModelAndView createDriverData()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("driverdata", DriverMapper.makeEmptyDriverDTO());
        modelAndView.setViewName("edit");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(value = "driverdatas", method = RequestMethod.POST)
    public ModelAndView saveDriverData(@Valid DriverDTO dt, BindingResult bindingResult) throws ConstraintsViolationException
    {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors())
        {
            modelAndView.setViewName("edit");
            modelAndView.addObject("driverdata", dt);
            modelAndView.addObject("errorMessage", "Driver data provided is incorrect.");
        }
        else
        {
            driverService.create(DriverMapper.makeDriverDOUI(dt));
            modelAndView.addObject("successMessage", "Driver data saved successfully.");
            modelAndView.addObject("driverdata", dt);
            modelAndView.setViewName("edit");
        }
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "driverdatas", method = RequestMethod.GET)
    public ModelAndView getAllDriverData()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("driverdatas", DriverMapper.makeDriverDTOList(driverService.findAllDrivers()));
        modelAndView.addObject("carInput", new CarInput());
        modelAndView.setViewName("driverdatas");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "driverdatas/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editDriverData(@PathVariable(value = "id") Integer id) throws EntityNotFoundException
    {
        ModelAndView modelAndView = new ModelAndView();
        DriverDTO dto = DriverMapper.makeDriverDTO(driverService.find(id.longValue()));
        modelAndView.addObject("driverdata", dto);
        modelAndView.setViewName("edit");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "driverdatas/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDriverData(@PathVariable(name = "id") Integer id) throws EntityNotFoundException
    {
        ModelAndView modelAndView = new ModelAndView();
        driverService.delete(id.longValue());
        modelAndView.setViewName("redirect:/driverdatas");
        return modelAndView;

    }


    @RequestMapping(path = "driverdatas/carSelect/{id}", method = RequestMethod.POST)
    public ModelAndView selectCar(@Valid CarInput dt, @PathVariable(value = "id") Integer driverId, BindingResult bindingResult)
        throws EntityNotFoundException, NumberFormatException, CarAlreadyInUseException
    {
        ModelAndView modelAndView = new ModelAndView();
        addLoggedInUserDetailsToView(modelAndView);
        modelAndView.setViewName("driverdatas");
        if (bindingResult.hasErrors())
        {
            modelAndView.addObject("errorMessage", "Selected Car data provided is incorrect.");
        }
        else
        {
            ResponseDTO selectCarResp = driverService.selectCar(driverId, Long.parseLong(dt.getSelectedCarId()));
            if ("000".equals(selectCarResp.getResponeCode()))
            {
                modelAndView.addObject("successMessage", selectCarResp.getResponseDescription());
            }
            else
            {
                modelAndView.addObject("errorMessage", selectCarResp.getResponseDescription());
            }
            modelAndView.addObject("driverdatas", DriverMapper.makeDriverDTOList(driverService.findAllDrivers()));
            modelAndView.addObject("carInput", new CarInput());
            modelAndView.setViewName("driverdatas");
        }
        return modelAndView;
    }


    @RequestMapping(path = "driverdatas/deselect/{id}", method = RequestMethod.GET)
    public ModelAndView deselectCar(@PathVariable(value = "id") Integer id) throws EntityNotFoundException
    {
        ModelAndView modelAndView = new ModelAndView();
        DriverDTO dto = DriverMapper.makeDriverDTO(driverService.find(id.longValue()));
        ResponseDTO selectCarResp = driverService.deselectCar(id, dto.getCarSelectedId().getId());
        if ("000".equals(selectCarResp.getResponeCode()))
        {
            modelAndView.addObject("successMessage", selectCarResp.getResponseDescription());
        }
        else
        {
            modelAndView.addObject("errorMessage", selectCarResp.getResponseDescription());
        }
        modelAndView.addObject("driverdatas", DriverMapper.makeDriverDTOList(driverService.findAllDrivers()));
        modelAndView.addObject("carInput", new CarInput());
        modelAndView.setViewName("driverdatas");

        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "cardatas/add", method = RequestMethod.GET)
    public ModelAndView createcarData()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cardata", CarMapper.makeEmptyCarDTO());
        modelAndView.setViewName("editCar");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(value = "cardatas", method = RequestMethod.POST)
    public ModelAndView savecarData(@Valid CarDTO dt, BindingResult bindingResult) throws ConstraintsViolationException
    {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors())
        {
            modelAndView.setViewName("editCar");
            modelAndView.addObject("cardata", dt);
            modelAndView.addObject("errorMessage", "Car data provided is incorrect.");
        }
        else
        {
            carService.create(CarMapper.makeCarDOUI(dt));
            modelAndView.addObject("successMessage", "Car data saved successfully.");
            modelAndView.addObject("cardata", dt);
            modelAndView.setViewName("editCar");
        }
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "cardatas", method = RequestMethod.GET)
    public ModelAndView getAllCarData()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cardatas", CarMapper.makeCarDTOList(carService.findAllCars()));
        modelAndView.setViewName("cardatas");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "cardatas/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCarData(@PathVariable(value = "id") Integer id) throws EntityNotFoundException
    {
        ModelAndView modelAndView = new ModelAndView();
        CarDTO dto = CarMapper.makeCarDTO(carService.find(id.longValue()));
        modelAndView.addObject("cardata", dto);
        modelAndView.setViewName("editCar");
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "cardatas/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCarData(@PathVariable(name = "id") Integer id) throws EntityNotFoundException
    {
        ModelAndView modelAndView = new ModelAndView();
        carService.delete(id.longValue());
        modelAndView.setViewName("redirect:/cardatas");
        return modelAndView;

    }


    @RequestMapping(path = "search", method = RequestMethod.GET)
    public ModelAndView getSearch()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("searchReport", new SearchReport());
        addLoggedInUserDetailsToView(modelAndView);
        return modelAndView;
    }


    @RequestMapping(path = "search", value = "search", method = RequestMethod.POST)
    public ModelAndView getSearchResults(@Valid SearchReport sReport, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search");
        addLoggedInUserDetailsToView(modelAndView);
        if (sReport == null || StringUtils.isEmpty(sReport.getDriverOrCarRadioB()))
        {
            modelAndView.addObject("searchReport", sReport);
            modelAndView.addObject("errorMessage", "Search criteria is incorrect. Please select Driver Data or Car Data.");
            return modelAndView;
        }
        else
        {
            if (sReport.getDriverOrCarRadioB().equalsIgnoreCase("driverdata"))
            {
                List<DriverDTO> drivers = null;
                if (!StringUtils.isEmpty(sReport.getOnlinestatus()))
                {
                    drivers = DriverMapper.makeDriverDTOList(driverService.find(OnlineStatus.valueOf(sReport.getOnlinestatus())));
                }
                else if (!StringUtils.isEmpty(sReport.getUsername()))
                {
                    drivers = DriverMapper.makeDriverDTOList(driverService.find(sReport.getUsername()));
                }
                modelAndView.addObject("driverdatas", drivers);

            }
            else if (sReport.getDriverOrCarRadioB().equalsIgnoreCase("cardata"))
            {
                List<CarDTO> cars = null;

                if (!StringUtils.isEmpty(sReport.getLicenseplate()))
                {
                    cars = CarMapper.makeCarDTOList(carService.findByLicensePlate(sReport.getLicenseplate()));
                }
                else if (!StringUtils.isEmpty(sReport.getRatings()))
                {
                    cars = CarMapper.makeCarDTOList(carService.findByRating(Ratings.valueOf(sReport.getRatings())));
                }

                else if (!StringUtils.isEmpty(sReport.getCarstatus()))
                {
                    cars = CarMapper.makeCarDTOList(carService.findByCarStatus(CarStatus.valueOf(sReport.getCarstatus())));
                }

                modelAndView.addObject("cardatas", cars);

            }
        }
        modelAndView.addObject("searchReport", sReport);
        return modelAndView;
    }


    private void addLoggedInUserDetailsToView(ModelAndView modelAndView)
    {
        modelAndView.addObject("userName", "Welcome " + loggedInUser.getName() + " (" + loggedInUser.getEmail() + ")");
        modelAndView.addObject("adminMessage", "Admin Role");
    }
}