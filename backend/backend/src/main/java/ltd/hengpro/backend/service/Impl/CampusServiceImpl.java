package ltd.hengpro.backend.service.Impl;

import ltd.hengpro.backend.dao.AreaDao;
import ltd.hengpro.backend.dao.CampusDao;
import ltd.hengpro.backend.entity.Area;
import ltd.hengpro.backend.entity.Campus;
import ltd.hengpro.backend.service.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class CampusServiceImpl implements CampusService {
    @Autowired
    AreaDao areaDao;

    @Autowired
    CampusDao campusDao;

    public Campus getCampusById(Integer campusId){
        return campusDao.findById(campusId).get();
    }

    @Override
    public Campus getCampusByName(String campusName) {
        return campusDao.findByCampusName(campusName);
    }

    public Campus deleteCampusById(Integer campusId){
        Campus campus = campusDao.findById(campusId).get();
        campusDao.delete(campus);
        List<Area> byCampusId = areaDao.findByCampusId(campus.getCampusId());
        areaDao.deleteAll(byCampusId);
        return campus;
    }
    public Campus addCampus(String campusName){
        Campus campus = new Campus();
        campus.setCampusName(campusName);
        Campus flush = campusDao.saveAndFlush(campus);
        return flush;
    }

    public Campus editCampus(Campus campus){
        return campusDao.saveAndFlush(campus);
    }

    public List<Campus> getCampusList(){

        return campusDao.findAll();
    }

    public List<Area> getAreaListByCampusId(Integer campusId){
        return areaDao.findByCampusId(campusId);
    }
}
