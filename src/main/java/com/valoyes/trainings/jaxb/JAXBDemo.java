package com.valoyes.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {

		try {
			// cremaos una instancia de JAXBContext, que es el entry point
			// a la JAXB API
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			// creamos una Unmarshaller instance
			Marshaller marshaller = context.createMarshaller();
			// creamos una instancia del objeto que queremos marshall
			Patient patient = new Patient();
			patient.setId(1);
			patient.setAge(7);
			patient.setName("Browson");
			// utilizamos el marshaller
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);
			// mostramos el contenido del writer
			System.out.println(writer);
			
			// ahora queremos unmarshall
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Patient unmarshalledPatient = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.println("unmarshalledPatient.getName() = " + unmarshalledPatient.getName());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

}
