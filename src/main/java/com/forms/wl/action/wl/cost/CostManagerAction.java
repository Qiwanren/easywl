package com.forms.wl.action.wl.cost;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forms.wl.entity.CommonEntity;
import com.forms.wl.entity.wl.cost.CostManagerEntity;
import com.forms.wl.service.CommonService;
import com.forms.wl.service.wl.cost.CostManagerService;
import com.forms.wl.tool.DateUtil;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/cost")
public class CostManagerAction {
	
	@Autowired
	private CommonService service;
	
	@Autowired
	private CostManagerService costService;
	
	@Autowired
	private DateUtil utils;
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpSession session){

		ModelAndView mv = new ModelAndView("cost/add");
		 
		List<CommonEntity> list = service.getBigType("cost");
		
		System.out.println("======= size = " + list.size());
		
		session.setAttribute("list", list);
		
		return mv ;
	}

	/**
	 * 得到业务小类数据
	 * @param response
	 * @param smallType
	 */
	@RequestMapping(value = "/getSmallType", method = RequestMethod.POST)
	public void getSmallType(HttpServletResponse response,
			@ModelAttribute(value = "smallType") String smallType) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String str = "";
		PrintWriter out = null;
		
		CommonEntity entity = new CommonEntity();
		CommonEntity entity1 = new CommonEntity();

		try {
			out = response.getWriter();
			entity.setCodeType("cost");
			entity.setSmallType(smallType);

			str = "";


			List<CommonEntity> list = service.getSmallType(entity);

			Iterator<CommonEntity> iterator = list.iterator();

			while (iterator.hasNext()) {

				entity1 = iterator.next();
				str += entity1.getCodeValue()+":"+entity1.getCodeDetail()+"|";

			}

			if ("".equals(str)) {

				str = "fail";

			} else {

				str = str.substring(0, str.length() - 1);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.write(str);
			out.close();
		}

	}
	
	/**
	 * 新增消费记录
	 * 
	 * @param session
	 * @param model1
	 * @param costInfo
	 * @return
	 */
	@RequestMapping(value = ("/add" ), method = RequestMethod.POST)
	public ModelAndView add(HttpSession session, Model model1, @ModelAttribute(value = "costInfo") CostManagerEntity costInfo){
		ModelAndView mv = new ModelAndView("success");
		
		costInfo.setCostId(utils.getKeyId());
		costInfo.setCostUser("admin");;
		costInfo.setAddDate(utils.getNowDate("yyyy-mm-dd"));
		costInfo.setAddTime(utils.getNowHour());
		
		costService.add(costInfo);
		session.setAttribute("R_URL", "/easyWL/cost/toAdd.do");
		session.setAttribute("R_URL_CONTENT", "继续录入");
		return mv;
	}
	
	/**
	 * 得到任务列表 - 分页
	 * 
	 * @param model2
	 * @return
	 */
	@RequestMapping("getCostListPage")
	public ModelAndView getCostListPage(Model model2, @ModelAttribute(value = "info") CostManagerEntity info) {
		
		ModelAndView model = new ModelAndView("cost/list");
		
		List<CostManagerEntity> list = costService.list(info);
		
		PageInfo<CostManagerEntity> pageInfo = new PageInfo<CostManagerEntity>(list);
	
		
		model2.addAttribute("list", list);
		model2.addAttribute("pageInfo",pageInfo);
		
		return model;
	}
	
	@RequestMapping("/toEdit" )
	public ModelAndView toEdit(HttpSession session, Model model1, @ModelAttribute(value = "costInfo") CostManagerEntity costInfo){
		
		ModelAndView mv = new ModelAndView("cost/edit");
		
		CostManagerEntity entity = costService.findById(costInfo.getCostId());
		List<CommonEntity> list = service.getBigType("cost");
		
		model1.addAttribute("info",entity);
		model1.addAttribute("list",list);
		
		//session.setAttribute("list", list);
		
		return mv;
	}
	
	@RequestMapping("/edit" )
	public ModelAndView edit(HttpSession session, Model model1, @ModelAttribute(value = "costInfo") CostManagerEntity costInfo){
		
		ModelAndView mv = new ModelAndView("success");
		
		costService.edit(costInfo);
		
		session.setAttribute("R_URL", "/easyWL/cost/getCostListPage.do");
		session.setAttribute("R_URL_CONTENT", "返回列表");
		return mv;
	}
	
	@RequestMapping("/delete" )
	public ModelAndView delete(HttpSession session, Model model1, @ModelAttribute(value = "costId") String costId){
		
		ModelAndView mv = new ModelAndView("success");
		
		costService.delete(costId);
		
		session.setAttribute("R_URL", "/easyWL/cost/getCostListPage.do");
		session.setAttribute("R_URL_CONTENT", "返回列表");
		return mv;
	}
	
}
