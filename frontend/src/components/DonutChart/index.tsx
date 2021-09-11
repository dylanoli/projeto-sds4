import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSun } from 'types/SaleSun';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    series: number[],
    labels: string[]
}
function DonutChart() {

    let chartData: ChartData = { series: [], labels: [] }

    axios.get(BASE_URL + '/sales/amount-by-seller')
        .then((response) => {
            const data = response.data as SaleSun[];
            const myLabels = data.map(x=>x.sellerName);
            const mySeries = data.map(x=> x.sum);
        })

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    )
}

export default DonutChart;