package CareersService.Assignment3.Config;

import CareersService.Assignment3.Entity.Job;
import CareersService.Assignment3.Repo.JobDtoRepository;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {
    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<Integer, Job> userCache(HazelcastInstance hazelcastInstance) {
        return hazelcastInstance.getMap("user-cache");
    }
}
