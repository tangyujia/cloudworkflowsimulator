package cws.core.scheduler;

import cws.core.Scheduler;
import cws.core.VM;
import cws.core.VMFactory;
import cws.core.WorkflowEngine;
import cws.core.cloudsim.CWSSimEntity;
import cws.core.cloudsim.CloudSimWrapper;
import cws.core.core.VMType;
import cws.core.engine.Environment;

/**
 * This scheduler submits jobs to VMs on FCFS basis.
 * Job is submitted to VM only if VM is idle (no queuing in VMs).
 * @author malawski
 */
abstract class DAGDynamicScheduler extends CWSSimEntity implements Scheduler {
    protected final Environment environment;

    public DAGDynamicScheduler(CloudSimWrapper cloudsim, Environment environment) {
        super("DAGDynamicScheduler", cloudsim);
        this.environment = environment;
    }

    @Override
    public abstract void scheduleJobs(WorkflowEngine engine);


    /**
     * Dumb for now, TODO implement correctly
     */
    protected VM selectBestVM() {
        VMType vmType = environment.getVmTypes().iterator().next();
        return VMFactory.createVM(vmType, getCloudsim());
    }
}
