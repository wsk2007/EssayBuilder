package org.wsk.EssayBuilder;
import org.joone.engine.FullSynapse;
import org.joone.engine.LinearLayer;
import org.joone.engine.Monitor;
import org.joone.engine.NeuralNetEvent;
import org.joone.engine.NeuralNetListener;
import org.joone.engine.SigmoidLayer;
import org.joone.engine.learning.TeachingSynapse;
import org.joone.io.MemoryInputSynapse;
import org.joone.net.NeuralNet;
@author(value = "wsk")
@Complain(details = "AI̫����", author = "wsk",  title = "��̫����", gread = Complain.grade.NORMAL)
public class AI implements NeuralNetListener {
	public void init(double[][] inputArray,boolean isLearning) {
		LinearLayer input = new LinearLayer();
		SigmoidLayer hidden1 = new SigmoidLayer();
		SigmoidLayer hidden2 = new SigmoidLayer();
		SigmoidLayer output = new SigmoidLayer();
		input.setRows(3);
		hidden1.setRows(5);
		hidden2.setRows(3);
		output.setRows(1);
		FullSynapse synapse_IH1 = new FullSynapse(); 
		FullSynapse synapse_H1H2 = new FullSynapse();
		FullSynapse synapse_H2O = new FullSynapse();
		input.addOutputSynapse(synapse_IH1);
		hidden1.addInputSynapse(synapse_IH1);
		hidden1.addOutputSynapse(synapse_H1H2);
		hidden2.addInputSynapse(synapse_H1H2);
		hidden2.addOutputSynapse(synapse_H2O);
		output.addInputSynapse(synapse_H2O);
		NeuralNet nnet = new NeuralNet();
		nnet.addLayer(input, NeuralNet.INPUT_LAYER);
		nnet.addLayer(hidden1, NeuralNet.HIDDEN_LAYER);
		nnet.addLayer(hidden2, NeuralNet.HIDDEN_LAYER);
		nnet.addLayer(output, NeuralNet.OUTPUT_LAYER);
		Monitor monitor = nnet.getMonitor();
		monitor.setLearningRate(0.8);
		monitor.setMomentum(0.3);
		monitor.addNeuralNetListener(this);
		MemoryInputSynapse memInp = new MemoryInputSynapse();
		memInp.setFirstRow(1);
		memInp.setAdvancedColumnSelector("1,2,3");
		memInp.setInputArray(inputArray);
		if(isLearning == true) {
			TeachingSynapse trainer = new TeachingSynapse();
		    MemoryInputSynapse sample = new MemoryInputSynapse();
		    sample.setFirstRow(1);
		    sample.setAdvancedColumnSelector("4");
		    sample.setInputArray(inputArray);
		    trainer.setDesired(sample);
		    output.addOutputSynapse(trainer);
			nnet.setTeacher(trainer);
			monitor.setTrainingPatterns(5); 
			monitor.setTotCicles(10000);
			monitor.setLearning(true); 
			nnet.go();
		}else{
			monitor.setLearning(false);
			nnet.go();
		}
		
		//TODO ʵ�����������
		//TODO ���Բ�ѵ����������
	}

	@Override
	public void cicleTerminated(NeuralNetEvent arg0) {
		// �˷���ֻ��Ϊ��ʵ��NeuralNetListener�ӿ�
		
	}

	@Override
	public void errorChanged(NeuralNetEvent arg0) {
		
		// �˷���ֻ��Ϊ��ʵ��NeuralNetListener�ӿ�
	}

	@Override
	public void netStarted(NeuralNetEvent arg0) {
		// �˷���ֻ��Ϊ��ʵ��NeuralNetListener�ӿ�
		
	}

	@Override
	public void netStopped(NeuralNetEvent arg0) {
		// �˷���ֻ��Ϊ��ʵ��NeuralNetListener�ӿ�
		
	}

	@Override
	@Complain(author = "wsk", details = "��������Ľӿ���ô����ô��Ҫʵ�ֵķ��������Ҷ�û��", gread = Complain.grade.ANGRY, title = "����ӿ�����***")
	public void netStoppedError(NeuralNetEvent arg0, String arg1) {
		// �˷���ֻ��Ϊ��ʵ��NeuralNetListener�ӿ�
		
	}
	@Complain(details = "ΪʲôҪʵ���������", author = "wsk",  title = "��***", gread = Complain.grade.LITTELANGRY)
	public void saveNnet(String location) {
		//TODO ʵ�ִ˷���
	}

}
