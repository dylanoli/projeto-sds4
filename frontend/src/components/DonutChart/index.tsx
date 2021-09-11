import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    series: number[],
    labels: string[]
}
function DonutChart() {
    const  [chartData, setChartData] = useState<ChartData>({ series: [], labels: [] });

    useEffect(()=>{
        axios.get(BASE_URL + '/sellers/sum-by-seller')
        .then((response) => {
            const data = response.data as SaleSum[];
            const labels = data.map(x=>x.sellerName);
            const series = data.map(x=> x.sum);
            setChartData({labels,series})
        })
    },[])
    

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